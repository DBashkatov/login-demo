package com.login.AuthDemo.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Enrollment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Speciality speciality;

    private LocalDate appStart;

    private LocalDate appEnd;

    private LocalDate testStart;

    private LocalDate testEnd;

    private LocalDateTime createdAt;

    @PrePersist
    private void prePersist(){
        createdAt = LocalDateTime.now();
    }
}