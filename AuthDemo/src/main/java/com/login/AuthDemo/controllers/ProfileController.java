package com.login.AuthDemo.controllers;

import com.login.AuthDemo.dto.CitiesSpecialitiesDto;
import com.login.AuthDemo.entities.City;
import com.login.AuthDemo.entities.Source;
import com.login.AuthDemo.entities.UserInfo;
import com.login.AuthDemo.service.Impl.CityServiceImpl;
import com.login.AuthDemo.service.Impl.SourceServiceImpl;
import com.login.AuthDemo.service.Impl.UserInfoServiceImpl;
import com.login.AuthDemo.service.Impl.UserServiceImpl;
import com.login.AuthDemo.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProfileController {

    @Autowired
    UserInfoServiceImpl userInfoService;

    @GetMapping("/api/profile")
    public UserInfo profile() {
        return userInfoService.getCurrentPrincipalUserInfo();
    }

    @GetMapping("/api/profile/edit")
    public CitiesSpecialitiesDto editProfile() {
        CitiesSpecialitiesDto citiesSpecialitiesDto = userInfoService.createCitiesSpecialitiesDto();
        return citiesSpecialitiesDto;
    }

    @PostMapping("/api//profile/edit")
    public void editProfile(@RequestBody UserInfoDto userInfoDto) {
        userInfoService.save(userInfoDto);
    }
}
