package com.login.AuthDemo.web;

import com.login.AuthDemo.model.City;
import com.login.AuthDemo.repository.CityRepository;
import com.login.AuthDemo.repository.SourceRepository;
import com.login.AuthDemo.service.UserInfoServiceImpl;
import com.login.AuthDemo.web.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProfileController {

    @Autowired
    CityRepository cityRepository;
    @Autowired
    SourceRepository sourceRepository;
    @Autowired
    UserInfoServiceImpl userInfoService;

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("userInfo", new UserInfoDto());
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("sources", sourceRepository.findAll());
        return "profile";
    }

    @PostMapping("/profile")
    public String profile(@ModelAttribute("userInfo") @Valid UserInfoDto userInfoDto){
        userInfoService.save(userInfoDto);
        return "home";
    }
}
