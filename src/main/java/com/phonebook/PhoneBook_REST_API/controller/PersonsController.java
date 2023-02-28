package com.phonebook.PhoneBook_REST_API.controller;

import com.phonebook.PhoneBook_REST_API.dto.Contact;
import com.phonebook.PhoneBook_REST_API.model.Persons;
import com.phonebook.PhoneBook_REST_API.repository.PersonsRepository;
import com.phonebook.PhoneBook_REST_API.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class PersonsController
{
    @Autowired
    private PersonsRepository personsRepository;
    @Autowired
    private PersonsService personsService;

    @GetMapping
    private List<Persons> getAll(){
        return  personsService.getAll();
    }

    @GetMapping("/fname/{fname}")
    public ResponseEntity<List<Persons>> getContactByFirstName(@PathVariable String fname)
    {
        return personsService.getContactByFirstName(fname);

    }


    @PostMapping("/NewContact")
    public Persons NewContact(@RequestBody Contact contact)
    {
        return personsRepository.save(contact.getPersons());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContact(@PathVariable int id){
        personsService.deleteById(id);
    }


    @DeleteMapping("/deleteByFnameAndLname")
    public String deleteContactByName(@RequestParam String fname,@RequestParam String lname)
    {
        return personsService.deleteByFnameAndLname(fname,lname) + " Contact deleted !!";
    }


    @PutMapping("Update/{id}")
    private Persons update(@PathVariable int id, @RequestBody Persons persons){
        persons.setId(id);
        return personsService.Update(persons);
    }
/*
    @PutMapping("UpdateByName/{id}")
    private Persons updateByName(@PathVariable String fname,@PathVariable String lname, @RequestBody Persons persons){
        persons.setFname(fname);
        persons.setLname(lname);
        return personsService.Update(persons);
    }
*/










}
