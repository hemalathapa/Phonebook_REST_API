package com.phonebook.PhoneBook_REST_API.repository;

import com.phonebook.PhoneBook_REST_API.model.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepository extends JpaRepository<Mobile,Integer>
{
}
