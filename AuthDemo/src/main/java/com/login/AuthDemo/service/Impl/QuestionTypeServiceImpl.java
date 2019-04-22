package com.login.AuthDemo.service.Impl;

import com.login.AuthDemo.entities.QuestionType;
import com.login.AuthDemo.repository.QuestionTypeRepository;
import com.login.AuthDemo.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
