package com.login.AuthDemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Speciality {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;
}
