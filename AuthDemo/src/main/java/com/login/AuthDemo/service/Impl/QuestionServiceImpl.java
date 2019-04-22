package com.login.AuthDemo.service.Impl;

import com.login.AuthDemo.dto.CitiesSpecialitiesDto;
import com.login.AuthDemo.dto.SpecialitiesQuestionTypesDto;
import com.login.AuthDemo.entities.*;
import com.login.AuthDemo.repository.QuestionRepository;
import com.login.AuthDemo.repository.QuestionTypeRepository;
import com.login.AuthDemo.repository.SpecialityRepository;
import com.login.AuthDemo.service.QuestionService;
import com.login.AuthDemo.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    SpecialityRepository specialityRepository;
    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> findBySpeciality(String speciality) {
        return questionRepository.findBySpeciality(specialityRepository.findByName(speciality));
    }

    @Override
    public void save(QuestionDto questionDto) {
        Question question = new Question();
        question.setText(questionDto.getText());
        question.setSpeciality(specialityRepository.findByName(questionDto.getSpeciality()));
        question.setQuestionType(questionTypeRepository.findByName(questionDto.getQuestionType()));
        questionRepository.save(question);
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public SpecialitiesQuestionTypesDto getSpecialitiesQuestionTypesDto() {
        SpecialitiesQuestionTypesDto specialitiesQuestionTypesDto = new SpecialitiesQuestionTypesDto();
        List<String> specialities = new ArrayList<>();
        List<String> questionTypes = new ArrayList<>();

        for (QuestionType questionType: questionTypeRepository.findAll()){
            questionTypes.add(questionType.getName());
        }

        for (Speciality speciality: specialityRepository.findAll()){
            specialities.add(speciality.getName());
        }

        specialitiesQuestionTypesDto.setQuestionTypes(questionTypes);
        specialitiesQuestionTypesDto.setSpecialities(specialities);

        return specialitiesQuestionTypesDto;
    }
}
