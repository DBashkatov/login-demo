package com.login.AuthDemo.service;

import com.login.AuthDemo.dto.SpecialitiesQuestionTypesDto;
import com.login.AuthDemo.entities.Question;
import com.login.AuthDemo.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();
    List<Question> findBySpeciality(String speciality);
    void save(QuestionDto questionDto);
    void deleteById(Long id);
    SpecialitiesQuestionTypesDto getSpecialitiesQuestionTypesDto();
}
