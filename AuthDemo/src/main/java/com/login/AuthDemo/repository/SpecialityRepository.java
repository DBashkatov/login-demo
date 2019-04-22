package com.login.AuthDemo.repository;

import com.login.AuthDemo.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    Speciality findByName(String name);
}