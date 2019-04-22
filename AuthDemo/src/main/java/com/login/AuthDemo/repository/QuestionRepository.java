package com.login.AuthDemo.repository;

import com.login.AuthDemo.entities.Question;
import com.login.AuthDemo.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findBySpeciality(Speciality speciality);
    Question findByText(String text);
}