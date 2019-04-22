package com.login.AuthDemo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class EnrollmentDto {

    @NotNull
    private Long id;

    @NotEmpty
    private String speciality;

    @NotEmpty
    private String appStart;

    @NotEmpty
    private String appEnd;

    @NotEmpty
    private String testStart;

    @NotEmpty
    private String testEnd;
}
