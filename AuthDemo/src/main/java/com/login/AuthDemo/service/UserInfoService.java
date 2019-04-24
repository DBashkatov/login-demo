package com.login.AuthDemo.service;

import com.login.AuthDemo.dto.CitiesSpecialitiesDto;
import com.login.AuthDemo.entities.UserInfo;
import com.login.AuthDemo.dto.UserInfoDto;

public interface UserInfoService {
    void save(UserInfoDto userInfoDto);
    UserInfo getCurrentPrincipalUserInfo();
}
