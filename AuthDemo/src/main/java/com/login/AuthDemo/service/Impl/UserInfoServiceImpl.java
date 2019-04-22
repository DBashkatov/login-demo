package com.login.AuthDemo.service.Impl;

import com.login.AuthDemo.dto.CitiesSpecialitiesDto;
import com.login.AuthDemo.entities.City;
import com.login.AuthDemo.entities.Source;
import com.login.AuthDemo.entities.UserInfo;
import com.login.AuthDemo.repository.CityRepository;
import com.login.AuthDemo.repository.SourceRepository;
import com.login.AuthDemo.repository.UserInfoRepository;
import com.login.AuthDemo.service.CityService;
import com.login.AuthDemo.service.UserInfoService;
import com.login.AuthDemo.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    SourceRepository sourceRepository;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    CityServiceImpl cityService;
    @Autowired
    SourceServiceImpl sourceService;

    @Override
    public void save(UserInfoDto userInfoDto) {
        UserInfo userInfo;

        if (userInfoRepository.findByUser(userService.getCurrentPrincipalUser()) != null)
            userInfo = getCurrentPrincipalUserInfo();
        else {
            userInfo = new UserInfo();
            userInfo.setUser(userService.getCurrentPrincipalUser());
        }

        userInfo.setFirstName(userInfoDto.getFirstName());
        userInfo.setLastName(userInfoDto.getLastName());
        userInfo.setCity(cityRepository.findByName(userInfoDto.getCity()));
        userInfo.setPhone(userInfoDto.getPhone());
        userInfo.setGrade(userInfoDto.getGrade());
        userInfo.setUniversity(userInfoDto.getUniversity());
        userInfo.setDepartment(userInfoDto.getDepartment());
        userInfo.setSpeciality(userInfoDto.getSpeciality());
        userInfo.setSource(sourceRepository.findByName(userInfoDto.getSource()));

        userInfoRepository.save(userInfo);
    }

    @Override
    public UserInfo getCurrentPrincipalUserInfo() {
        UserInfo userInfo = userInfoRepository.findByUser(userService.getCurrentPrincipalUser());
        return userInfo;
    }

    @Override
    public CitiesSpecialitiesDto createCitiesSpecialitiesDto() {
        CitiesSpecialitiesDto citiesSpecialitiesDto = new CitiesSpecialitiesDto();
        List<String> cities = new ArrayList<>();
        List<String> sources = new ArrayList<>();

        for (City city : cityService.findAll()) {
            cities.add(city.getName());
        }

        for (Source source : sourceService.findAll()) {
            sources.add(source.getName());
        }

        citiesSpecialitiesDto.setCities(cities);
        citiesSpecialitiesDto.setSources(sources);
        return citiesSpecialitiesDto;
    }
}
