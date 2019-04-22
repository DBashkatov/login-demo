package com.login.AuthDemo.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserRegistrationDto {

    @NotNull
    private Long id;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}
