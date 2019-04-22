package com.login.AuthDemo.service;

import com.login.AuthDemo.entities.Answer;
import com.login.AuthDemo.dto.AnswerDto;

import java.util.List;

public interface AnswerService {
    List<Answer> findByQuestion(String question);
    void save(AnswerDto answerDto, String question);
}
