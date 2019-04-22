package com.login.AuthDemo.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class TestUser {

    @Id
    @GeneratedValue
    private Long id;

    private boolean isCorrect;

    @ManyToOne
    private Test test;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Answer answer;

    private String studentAnswer;

}