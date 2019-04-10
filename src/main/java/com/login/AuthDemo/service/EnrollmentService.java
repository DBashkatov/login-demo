package com.login.AuthDemo.service;

import com.login.AuthDemo.model.Enrollment;
import com.login.AuthDemo.web.dto.EnrollmentDto;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> findAll();
    void deleteById(Long id);
    void save(EnrollmentDto enrollmentDto);
}
