package com.login.AuthDemo.service;

import com.login.AuthDemo.model.UserInfo;
import com.login.AuthDemo.web.dto.UserInfoDto;

public interface UserInfoService {
    void save(UserInfoDto userInfoDto);
    UserInfo getCurrentPrincipalUserInfo();
}
