package com.login.AuthDemo.repository;

import com.login.AuthDemo.model.Enrollment;
import com.login.AuthDemo.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Set<Enrollment> findBySpeciality(Speciality speciality);
}