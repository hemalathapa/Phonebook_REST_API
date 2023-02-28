package com.phonebook.PhoneBook_REST_API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Table(name="personDetails")
public class Persons
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="fname")
    private String fname;
    @Column(name="lname")
    private String lname;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id",referencedColumnName = "id")
    private List<Mobile> mobiles;

    public Persons(String fname,String lname)
    {
        this.fname=fname;
        this.lname=lname;
    }

}
