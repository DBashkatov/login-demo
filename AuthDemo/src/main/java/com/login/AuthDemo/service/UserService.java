package com.login.AuthDemo.service;

import com.login.AuthDemo.entities.User;
import com.login.AuthDemo.dto.UserRegistrationDto;

public interface UserService {
    void save(UserRegistrationDto userRegistrationDto);
    void saveAdmin();
    User findByEmail(String username);
    User getCurrentPrincipalUser();
}
