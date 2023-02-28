package com.phonebook.PhoneBook_REST_API.dto;

import com.phonebook.PhoneBook_REST_API.model.Persons;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contact
{
    private Persons persons;

}
