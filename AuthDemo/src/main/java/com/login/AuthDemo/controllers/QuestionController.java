package com.login.AuthDemo.controllers;

import com.login.AuthDemo.dto.SpecialitiesQuestionTypesDto;
import com.login.AuthDemo.entities.Question;
import com.login.AuthDemo.service.Impl.EnrollmentServiceImpl;
import com.login.AuthDemo.service.Impl.QuestionServiceImpl;
import com.login.AuthDemo.service.Impl.QuestionTypeServiceImpl;
import com.login.AuthDemo.service.Impl.SpecialityServiceImpl;
import com.login.AuthDemo.dto.AnswerDto;
import com.login.AuthDemo.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class QuestionController {
    @Autowired
    SpecialityServiceImpl specialityService;
    @Autowired
    EnrollmentServiceImpl enrollmentService;
    @Autowired
    QuestionServiceImpl questionService;
    @Autowired
    QuestionTypeServiceImpl questionTypeService;

    @GetMapping("/api/questions/all")
    public List<Question> getAllQuestions(){
        return questionService.findAll();
    }

    @GetMapping("/api/questions/add")
    public SpecialitiesQuestionTypesDto addQuestion(){
        return questionService.getSpecialitiesQuestionTypesDto();
    }

    @PostMapping("/api/questions/add")
    public void addQuestion(@RequestBody QuestionDto questionDto){
        questionService.save(questionDto);
    }

    @DeleteMapping("/api/questions/{id}/delete")
    public void deleteQuestion(@PathVariable("id") Long id) {
        questionService.deleteById(id);
    }
}
