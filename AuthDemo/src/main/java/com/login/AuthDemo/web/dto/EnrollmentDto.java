package com.login.AuthDemo.web.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class EnrollmentDto {

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
