package com.login.AuthDemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Source {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
