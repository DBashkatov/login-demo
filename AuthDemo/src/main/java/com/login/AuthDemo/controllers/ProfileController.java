package com.login.AuthDemo.controllers;

import com.login.AuthDemo.AuthDemoApplication;
import com.login.AuthDemo.converters.UserInfoConv;
import com.login.AuthDemo.dto.UserInfoDto;
import com.login.AuthDemo.entities.UserInfo;
import com.login.AuthDemo.service.Impl.UserInfoServiceImpl;
import org.jboss.logging.LoggingClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProfileController {

    @Autowired
    UserInfoServiceImpl userInfoService;
    @Autowired
    UserInfoConv userInfoConv;

    @GetMapping("/api/profile")
    public ResponseEntity<?> getProfile() {
        UserInfo userInfo = userInfoService.getCurrentPrincipalUserInfo();
        if (userInfo != null)
            return new ResponseEntity(userInfoConv.userInfoToDto(userInfo), HttpStatus.OK);
        return new ResponseEntity(new UserInfoDto(), HttpStatus.OK);
    }

    @PostMapping("/api/profile")
    public ResponseEntity<?> updateProfile(@Valid @RequestBody UserInfoDto userInfoDto) {
        userInfoService.save(userInfoDto);
        return new ResponseEntity<>("User info updated successfully!", HttpStatus.OK);
    }
}
