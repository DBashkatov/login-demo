package com.login.AuthDemo.controllers;

import com.login.AuthDemo.entities.Speciality;
import com.login.AuthDemo.service.Impl.EnrollmentServiceImpl;
import com.login.AuthDemo.service.Impl.SpecialityServiceImpl;
import com.login.AuthDemo.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HomeController {

    @Autowired
    SpecialityServiceImpl specialityService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    EnrollmentServiceImpl enrollmentService;

    @GetMapping("/api/specialities/all")
    public List<Speciality> home() {
        if (userService.findByEmail("admin") == null)
            userService.saveAdmin();

        return specialityService.findAll();
    }

    @GetMapping("/api/specialities/{id}")
    public Speciality getSpeciality(@PathVariable("id") Long id) {
        return specialityService.findById(id);
    }
}
