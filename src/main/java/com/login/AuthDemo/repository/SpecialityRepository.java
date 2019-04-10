package com.login.AuthDemo.repository;

import com.login.AuthDemo.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    Speciality findByName(String name);
}