package com.login.AuthDemo.repository;

import com.login.AuthDemo.entities.Answer;
import com.login.AuthDemo.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestion(Question question);
}
