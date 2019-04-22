package com.login.AuthDemo.service.Impl;

import com.login.AuthDemo.entities.User;
import com.login.AuthDemo.repository.RoleRepository;
import com.login.AuthDemo.repository.UserRepository;
import com.login.AuthDemo.service.UserService;
import com.login.AuthDemo.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userRegistrationDto.getPassword()));
        user.setRoles(new HashSet(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
        userRepository.save(user);
    }

    @Override
    public void saveAdmin() {
        User user = new User();
        user.setEmail("admin");
        user.setPassword(bCryptPasswordEncoder.encode("admin"));
        user.setRoles(new HashSet(Arrays.asList(roleRepository.findByName("ROLE_ADMIN"))));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getCurrentPrincipalUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userRepository.findByEmail(currentPrincipalName);
        return user;
    }
}
