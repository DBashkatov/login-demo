package com.login.AuthDemo.service.Impl;

import com.login.AuthDemo.entities.City;
import com.login.AuthDemo.repository.CityRepository;
import com.login.AuthDemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
