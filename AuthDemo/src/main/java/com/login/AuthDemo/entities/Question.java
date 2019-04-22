package com.login.AuthDemo.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @ManyToOne
    private Speciality speciality;

    @ManyToOne
    private QuestionType questionType;
}
