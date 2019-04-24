package com.login.AuthDemo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String studentStatus;

    private String firstName;

    private String lastName;

    private String city;

    private String phone;

    private Integer grade;

    private String university;

    private String department;

    private String speciality;

    @OneToOne
    private User user;

    @ManyToOne
    private Enrollment enrollment;
}
