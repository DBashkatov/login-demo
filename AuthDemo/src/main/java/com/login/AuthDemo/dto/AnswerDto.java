package com.login.AuthDemo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnswerDto {

    @NotNull
    private Long id;

    @NotEmpty
    String text;

    @NotNull
    boolean correct;
}
