package com.login.AuthDemo.web.dto;

import com.login.AuthDemo.validator.PasswordMatches;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@PasswordMatches
public class UserRegistrationDto {

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String passwordConfirm;
}
