package com.phonebook.phoneBook_REST_API.controller;

import com.phonebook.phoneBook_REST_API.dto.Contact;
import com.phonebook.phoneBook_REST_API.model.Persons;
import com.phonebook.phoneBook_REST_API.repository.PersonsRepository;
import com.phonebook.phoneBook_REST_API.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Persons> getAll(){
        return  personsService.getAll();
    }

    @GetMapping("/fname/{fname}")
    public List<Persons> getContactByFirstName(@PathVariable String fname)
    {
        return personsService.getContactByFirstName(fname);

    }

    @PostMapping("/NewContact")
    public Persons newContact(@RequestBody Contact contact)
    {
        return personsRepository.save(contact.getPersons());
    }

    @PutMapping("Update/{id}")
    public Persons update(@PathVariable int id, @RequestBody Persons persons){
        persons.setId(id);
        return personsService.update(persons);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContact(@PathVariable int id){
        personsService.deleteById(id);
    }


    @DeleteMapping("/deleteByFnameAndLname/{fname}/{lname}")
    public String deleteContactByName(@PathVariable String fname,@PathVariable String lname)
    {
        return personsService.deleteByFnameAndLname(fname,lname) + " Contact deleted !!";
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
