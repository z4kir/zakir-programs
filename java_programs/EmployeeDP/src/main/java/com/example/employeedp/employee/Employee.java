package com.example.employeedp.employee;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "login")
public class Employee {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
