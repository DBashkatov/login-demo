package com.login.AuthDemo.repository;

import com.login.AuthDemo.entities.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTypeRepository extends JpaRepository<QuestionType, Long> {
    QuestionType findByName(String name);
}