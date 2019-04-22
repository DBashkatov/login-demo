package com.login.AuthDemo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "user_account")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String password;

    @ManyToMany
    private Set<Role> roles;
}
