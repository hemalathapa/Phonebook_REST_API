package com.phonebook.PhoneBook_REST_API.service;


import com.phonebook.PhoneBook_REST_API.model.Mobile;
import com.phonebook.PhoneBook_REST_API.model.Persons;
import com.phonebook.PhoneBook_REST_API.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class PersonsService {

    @Autowired
    private PersonsRepository personsRepository;


    //Method to get all the contacts
    public List<Persons> getAll(){
        return personsRepository.findAll();
    }


    //Method to get contact by first name
    public ResponseEntity<List<Persons>> getContactByFirstName(@RequestParam String fname)
    {
        return new ResponseEntity<List<Persons>>(personsRepository.findByFname(fname), HttpStatus.OK);

    }



    //Method to add a new contact
    public Persons addContact(Persons persons){

        return personsRepository.save(persons);
    }

    //Method to delete a Contact by id
    public boolean deleteById(int id){
        personsRepository.deleteById(id);
        return true;
    }

    //Method to delete a contact by firstname
    public Integer deleteByFnameAndLname(@RequestParam  String fname,@RequestParam String lname)
    {
       return personsRepository.deleteByFnameAndLname(fname,lname);

    }

    //Method to update a contact details
/*
    public Persons updateContact(Persons persons)
    {
        return personsRepository.save(persons);

    }


 */

    public Persons Update(Persons persons)
    {
        return personsRepository.save(persons);
    }











}
