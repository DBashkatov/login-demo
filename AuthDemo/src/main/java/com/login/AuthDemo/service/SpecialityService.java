package com.login.AuthDemo.service;

import com.login.AuthDemo.entities.Speciality;

import java.util.List;

public interface SpecialityService {
    List<Speciality> findAll();
    Speciality findById(Long id);
}
