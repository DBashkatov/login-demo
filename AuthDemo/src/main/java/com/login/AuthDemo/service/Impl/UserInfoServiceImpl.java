package com.login.AuthDemo.service.Impl;

import com.login.AuthDemo.converters.UserInfoConv;
import com.login.AuthDemo.dto.UserInfoDto;
import com.login.AuthDemo.entities.UserInfo;
import com.login.AuthDemo.repository.CityRepository;
import com.login.AuthDemo.repository.UserInfoRepository;
import com.login.AuthDemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    CityServiceImpl cityService;
    @Autowired
    UserInfoConv userInfoConv;

    @Override
    public void save(UserInfoDto userInfoDto) {
        UserInfo userInfo = userInfoConv.userInfoFromDto(userInfoDto);

        userInfoRepository.save(userInfo);
    }

    @Override
    public UserInfo getCurrentPrincipalUserInfo() {
        UserInfo userInfo = userInfoRepository.findByUser(userService.getCurrentPrincipalUser());
        return userInfo;
    }
}
