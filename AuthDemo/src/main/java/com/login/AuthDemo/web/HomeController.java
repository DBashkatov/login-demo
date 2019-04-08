package com.login.AuthDemo.web;

import com.login.AuthDemo.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    SpecialityRepository specialityRepository;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("specialities", specialityRepository.findAll());
        return "home";
    }

    @GetMapping("/speciality")
    public String speciality(@RequestParam Long id, Model model) {
        model.addAttribute("speciality", specialityRepository.findById(id).get());
        return "speciality";
    }

}
