package com.login.AuthDemo.web;

import com.login.AuthDemo.repository.EnrollmentRepository;
import com.login.AuthDemo.repository.SpecialityRepository;
import com.login.AuthDemo.service.EnrollmentServiceImpl;
import com.login.AuthDemo.service.SpecialityServiceImpl;
import com.login.AuthDemo.web.dto.EnrollmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AdminController {

    @Autowired
    SpecialityServiceImpl specialityService;
    @Autowired
    EnrollmentServiceImpl enrollmentService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("enrollments", enrollmentService.findAll());
        return "admin";
    }

    @GetMapping("enrollment/add")
    public String putEnrollment(Model model){
        model.addAttribute("enrollment", new EnrollmentDto());
        model.addAttribute("specialities", specialityService.findAll());
        return "enrollment";
    }

    @PostMapping("enrollment/add")
    public String putEnrollment(@ModelAttribute("enrollment") @Valid EnrollmentDto enrollmentDto){
        enrollmentService.save(enrollmentDto);
        return "redirect:/admin";
    }

    @DeleteMapping("enrollment/{id}/delete")
    public String deleteEnrollment(@PathVariable("id") Long id){
        enrollmentService.deleteById(id);
        return "redirect:/admin";
    }
}
