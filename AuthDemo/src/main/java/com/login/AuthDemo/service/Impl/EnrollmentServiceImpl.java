package com.login.AuthDemo.service.Impl;

import com.login.AuthDemo.entities.Enrollment;
import com.login.AuthDemo.repository.EnrollmentRepository;
import com.login.AuthDemo.repository.SpecialityRepository;
import com.login.AuthDemo.service.EnrollmentService;
import com.login.AuthDemo.dto.EnrollmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    EnrollmentRepository enrollmentRepository;
    @Autowired
    SpecialityRepository specialityRepository;

    @Override
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);
    }

    @Override
    public void save(EnrollmentDto enrollmentDto) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault());
        LocalDate date;

        Enrollment enrollment = new Enrollment();
        enrollment.setSpeciality(specialityRepository.findByName(enrollmentDto.getSpeciality()));
        date = LocalDate.parse(enrollmentDto.getAppStart(), formatter);
        enrollment.setAppStart(date);
        date = LocalDate.parse(enrollmentDto.getAppEnd(), formatter);
        enrollment.setAppEnd(date);
        date = LocalDate.parse(enrollmentDto.getTestStart(), formatter);
        enrollment.setTestStart(date);
        date = LocalDate.parse(enrollmentDto.getTestEnd(), formatter);
        enrollment.setTestEnd(date);
        enrollmentRepository.save(enrollment);
    }

    @Override
    public Set<Enrollment> findBySpeciality(String speciality) {
        return enrollmentRepository.findBySpeciality(specialityRepository.findByName(speciality));
    }
}
