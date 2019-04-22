package com.login.AuthDemo.controllers;

import com.login.AuthDemo.config.TokenProvider;
import com.login.AuthDemo.dto.JwtDto;
import com.login.AuthDemo.dto.LoginDto;
import com.login.AuthDemo.dto.UserRegistrationDto;
import com.login.AuthDemo.service.Impl.SecurityServiceImpl;
import com.login.AuthDemo.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    SecurityServiceImpl securityService;
    @Autowired
    TokenProvider tokenProvider;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/api/registration")
    public ResponseEntity<?> registration(@ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto, BindingResult bindingResult) {
        if (userService.findByEmail(userRegistrationDto.getEmail()) != null)
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        userService.save(userRegistrationDto);
        securityService.autoLogin(userRegistrationDto.getEmail(), userRegistrationDto.getPassword());
        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
}
