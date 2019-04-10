package com.login.AuthDemo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
