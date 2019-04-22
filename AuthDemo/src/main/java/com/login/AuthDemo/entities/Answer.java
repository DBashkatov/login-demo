package com.login.AuthDemo.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Answer {

    @Id
    @GeneratedValue
    private Long id;

    String text;

    boolean correct;

    @ManyToOne
    Question question;
}
