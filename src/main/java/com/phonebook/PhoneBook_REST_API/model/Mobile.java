package com.phonebook.PhoneBook_REST_API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="mobile")
public class Mobile
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int m_id;

    @Column(name = "number")
    private String number;

    @Column(name = "type")
    private String type;


}
