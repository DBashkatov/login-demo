package com.login.AuthDemo.web;

import com.login.AuthDemo.service.SecurityServiceImpl;
import com.login.AuthDemo.service.UserServiceImpl;
import com.login.AuthDemo.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    SecurityServiceImpl securityService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") @Valid  UserRegistrationDto userRegistrationDto, BindingResult bindingResult) {
        if (userService.findByEmail(userRegistrationDto.getEmail()) != null)
            bindingResult.rejectValue("email", null, "There is already an account registered with that email");
        if (bindingResult.hasErrors())
            return "registration";
        userService.save(userRegistrationDto);
        securityService.autoLogin(userRegistrationDto.getEmail(),userRegistrationDto.getPassword());
        return "redirect:/login?success";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }
}
