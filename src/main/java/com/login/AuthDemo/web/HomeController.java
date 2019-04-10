package com.login.AuthDemo.web;

import com.login.AuthDemo.repository.SpecialityRepository;
import com.login.AuthDemo.repository.UserRepository;
import com.login.AuthDemo.service.SpecialityServiceImpl;
import com.login.AuthDemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    SpecialityServiceImpl specialityService;
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (userService.findByEmail("admin") == null)
            userService.saveAdmin();

        model.addAttribute("specialities", specialityService.findAll());
        return "home";
    }

    @GetMapping("/speciality")
    public String speciality(@RequestParam Long id, Model model) {
        model.addAttribute("speciality", specialityService.findById(id));
        return "speciality";
    }

}
