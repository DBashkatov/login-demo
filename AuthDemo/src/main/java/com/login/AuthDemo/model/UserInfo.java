package com.login.AuthDemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @ManyToOne
    private City city;

    private String phone;

    private Integer grade;

    private String university;

    private String department;

    private String speciality;

    @ManyToOne
    private Source source;

    @OneToOne
    private User user;
}