package com.phonebook.phoneBook_REST_API.repository;

import com.phonebook.phoneBook_REST_API.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PersonsRepository extends JpaRepository<Persons,Integer>
{
    public List<Persons> findByFname(String fname);

    @Modifying
    public int deleteByFnameAndLname(String fname,String lname);







}
