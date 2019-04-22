package com.login.AuthDemo.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Speciality {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;
}
