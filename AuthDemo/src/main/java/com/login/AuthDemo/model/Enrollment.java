package com.login.AuthDemo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Enrollment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Speciality speciality;

    private Date appStart;

    private Date appEnd;

    private Date testStart;

    private Date testEnd;

    private LocalDateTime createdAt;

    @PrePersist
    private void prePersist(){
        createdAt = LocalDateTime.now();
    }
}