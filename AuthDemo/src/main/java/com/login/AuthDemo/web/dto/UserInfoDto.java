package com.login.AuthDemo.web.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserInfoDto {

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
