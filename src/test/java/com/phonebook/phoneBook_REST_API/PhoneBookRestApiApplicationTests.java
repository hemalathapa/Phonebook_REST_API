package com.phonebook.phoneBook_REST_API;

import com.phonebook.phoneBook_REST_API.model.Persons;
import com.phonebook.phoneBook_REST_API.repository.PersonsRepository;
import com.phonebook.phoneBook_REST_API.service.PersonsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class PhoneBookRestApiApplicationTests {

	@Autowired
	private PersonsService service;
	@MockBean
	private PersonsRepository repo;

	@Test
	public void getAllTest()
	{
		when(repo.findAll()).thenReturn(Stream.of(new Persons("Hema","Latha"),new Persons("Siva","Kumar"),new Persons("Hema","Mohan")).collect(Collectors.toList()));
		int actual=service.getAll().size();
        assertEquals("success",3,actual);
	}

	@Test
	public void getContactByFirstNameTest()
	{
		String fname="Hema";
		when(repo.findByFname(fname)).thenReturn(Stream.of(new Persons("Hema","Latha"),new Persons("Hema","Mohan")).collect(Collectors.toList()));
		int actual=service.getContactByFirstName(fname).size();
		assertEquals("Found 2 Contacts",2,actual);
	}

	@Test
	public void deleteByFnameAndLname()
	{
		String fname="Siva";
		String lname="Kumar";

		when(repo.deleteByFnameAndLname(fname,lname)).thenReturn(Stream.of(new Persons("Siva","Kumar")).collect(Collectors.toList()).size());

		assertEquals("1 Contact deleted",1,service.deleteByFnameAndLname(fname,lname));
	}



}
