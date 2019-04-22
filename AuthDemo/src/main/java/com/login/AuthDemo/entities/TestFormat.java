package com.login.AuthDemo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class TestFormat {

    @Id
    @GeneratedValue
    private Long id;

    private int time;

    private int numberOfQuestions;

    @ManyToOne
    private Speciality speciality;

}