package com.login.AuthDemo.service.Impl;

import com.login.AuthDemo.entities.Speciality;
import com.login.AuthDemo.repository.SpecialityRepository;
import com.login.AuthDemo.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    SpecialityRepository specialityRepository;

    @Override
    public List<Speciality> findAll() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).get();
    }
}
