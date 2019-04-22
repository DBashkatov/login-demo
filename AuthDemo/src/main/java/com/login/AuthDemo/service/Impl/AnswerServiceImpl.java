package com.login.AuthDemo.service.Impl;

import com.login.AuthDemo.entities.Answer;
import com.login.AuthDemo.repository.AnswerRepository;
import com.login.AuthDemo.repository.QuestionRepository;
import com.login.AuthDemo.service.AnswerService;
import com.login.AuthDemo.dto.AnswerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Answer> findByQuestion(String question) {
        return answerRepository.findByQuestion(questionRepository.findByText(question));
    }

    @Override
    public void save(AnswerDto answerDto, String question) {
        Answer answer = new Answer();
        answer.setText(answerDto.getText());
        answer.setCorrect(answerDto.isCorrect());
        answer.setQuestion(questionRepository.findByText(question));
        answerRepository.save(answer);
    }
}
