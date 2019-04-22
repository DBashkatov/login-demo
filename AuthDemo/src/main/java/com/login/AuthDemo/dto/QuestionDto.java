package com.login.AuthDemo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class QuestionDto {

    @NotNull
    private Long id;

    @NotEmpty
    private String text;

    @NotEmpty
    private String speciality;

    @NotEmpty
    private String questionType;
}
