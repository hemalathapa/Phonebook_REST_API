package com.phonebook.PhoneBook_REST_API.service;

import com.phonebook.PhoneBook_REST_API.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileService
{
    @Autowired
    private MobileRepository mobileRepository;

}
