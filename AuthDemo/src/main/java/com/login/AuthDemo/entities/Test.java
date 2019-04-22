package com.login.AuthDemo.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Test {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime takenAt;

    private boolean passed;

    @ManyToOne
    private TestFormat testFormat;

    @ManyToOne
    private User user;

    @PrePersist
    private void prePersist(){
        takenAt = LocalDateTime.now();
    }
}