package com.login.AuthDemo.controllers;

import com.login.AuthDemo.entities.Speciality;
import com.login.AuthDemo.service.Impl.EnrollmentServiceImpl;
import com.login.AuthDemo.service.Impl.SpecialityServiceImpl;
import com.login.AuthDemo.dto.EnrollmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EnrollmentController {

    @Autowired
    SpecialityServiceImpl specialityService;
    @Autowired
    EnrollmentServiceImpl enrollmentService;

    @GetMapping("/api/enrollments/all")
//    public List<Enrollment> getAllEnrollments(){
    public List<EnrollmentDto> getAllEnrollments(){
        List<EnrollmentDto> enrollmentDtos = new ArrayList<>();
        EnrollmentDto enrollmentDto = new EnrollmentDto();
        enrollmentDto.setId(1l);
        enrollmentDto.setSpeciality("qa");
        enrollmentDto.setAppEnd("2011-11-11");
        enrollmentDto.setAppStart("2011-11-11");
        enrollmentDto.setTestEnd("2011-11-11");
        enrollmentDto.setTestStart("2011-11-11");
        enrollmentDtos.add(enrollmentDto);
        enrollmentDtos.add(enrollmentDto);
        enrollmentDtos.add(enrollmentDto);
        enrollmentDtos.add(enrollmentDto);
        enrollmentDtos.add(enrollmentDto);
        return enrollmentDtos;
//        return enrollmentService.findAll();
    }

    @GetMapping("/api/enrollments/add")
    public List<Speciality> addEnrollment() {
        return specialityService.findAll();
    }

    @PostMapping("/api/enrollments/add")
    public void addEnrollment(@RequestBody EnrollmentDto enrollmentDto) {
        enrollmentService.save(enrollmentDto);
    }

    @DeleteMapping("/api/enrollments/{id}/delete")
    public void deleteEnrollment(@PathVariable("id") Long id) {
        enrollmentService.deleteById(id);
    }
}
