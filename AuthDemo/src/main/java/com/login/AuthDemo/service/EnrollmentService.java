package com.login.AuthDemo.service;

import com.login.AuthDemo.entities.Enrollment;
import com.login.AuthDemo.dto.EnrollmentDto;

import java.util.List;
import java.util.Set;

public interface EnrollmentService {
    List<Enrollment> findAll();
    void deleteById(Long id);
    void save(EnrollmentDto enrollmentDto);
    Set<Enrollment> findBySpeciality(String speciality);
}
