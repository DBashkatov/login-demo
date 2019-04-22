package com.login.AuthDemo.repository;

import com.login.AuthDemo.entities.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<Source, Long> {
    Source findByName(String name);
}