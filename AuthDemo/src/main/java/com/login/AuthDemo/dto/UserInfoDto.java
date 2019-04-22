package com.login.AuthDemo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserInfoDto {

    @NotNull
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String city;

    @NotEmpty
    private String phone;

    private Integer grade;

    @NotEmpty
    private String university;

    @NotEmpty
    private String department;

    @NotEmpty
    private String speciality;

    @NotEmpty
    private String source;
}
