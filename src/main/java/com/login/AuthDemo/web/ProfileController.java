package com.login.AuthDemo.web;

import com.login.AuthDemo.model.UserInfo;
import com.login.AuthDemo.repository.CityRepository;
import com.login.AuthDemo.repository.SourceRepository;
import com.login.AuthDemo.repository.UserInfoRepository;
import com.login.AuthDemo.service.CityServiceImpl;
import com.login.AuthDemo.service.SourceServiceImpl;
import com.login.AuthDemo.service.UserInfoServiceImpl;
import com.login.AuthDemo.service.UserServiceImpl;
import com.login.AuthDemo.web.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProfileController {

    @Autowired
    UserInfoServiceImpl userInfoService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    CityServiceImpl cityService;
    @Autowired
    SourceServiceImpl sourceService;

    @GetMapping("/profile")
    public String profile(Model model) {
        UserInfo userInfo = userInfoService.getCurrentPrincipalUserInfo();

        if (userInfo == null)
            return "redirect:/profile/edit";

        model.addAttribute("userInfo", userInfo);
        return "userInfo";
    }

    @GetMapping("/profile/edit")
    public String editProfile(Model model) {
        model.addAttribute("userInfo", new UserInfoDto());
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("sources", sourceService.findAll());
        return "profile";
    }

    @PostMapping("/profile")
    public String editProfile(@ModelAttribute("userInfo") @Valid UserInfoDto userInfoDto){
        userInfoService.save(userInfoDto);
        return "redirect:/profile";
    }
}
