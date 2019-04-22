package com.login.AuthDemo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
