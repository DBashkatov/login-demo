package com.login.AuthDemo.service;

import com.login.AuthDemo.model.UserInfo;
import com.login.AuthDemo.repository.CityRepository;
import com.login.AuthDemo.repository.SourceRepository;
import com.login.AuthDemo.repository.UserInfoRepository;
import com.login.AuthDemo.repository.UserRepository;
import com.login.AuthDemo.web.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    SourceRepository sourceRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public String getPrincipalName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

    @Override
    public void save(UserInfoDto userInfoDto) {
        String name = getPrincipalName();
        UserInfo userInfo = new UserInfo();

        userInfo.setFirstName(userInfoDto.getFirstName());
        userInfo.setLastName(userInfoDto.getLastName());
        userInfo.setCity(cityRepository.findByName(userInfoDto.getCity()));
        userInfo.setPhone(userInfoDto.getPhone());
        userInfo.setGrade(userInfoDto.getGrade());
        userInfo.setUniversity(userInfoDto.getUniversity());
        userInfo.setDepartment(userInfoDto.getDepartment());
        userInfo.setSpeciality(userInfoDto.getSpeciality());
        userInfo.setSource(sourceRepository.findByName(userInfoDto.getSource()));
        userInfo.setUser(userRepository.findByEmail(name));

        userInfoRepository.save(userInfo);
    }
}
