package com.login.AuthDemo.service;

import com.login.AuthDemo.model.User;
import com.login.AuthDemo.web.dto.UserRegistrationDto;

public interface UserService {
    void save(UserRegistrationDto userRegistrationDto);
    User findByEmail(String username);
}
