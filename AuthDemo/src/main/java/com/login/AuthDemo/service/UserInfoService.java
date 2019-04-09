package com.login.AuthDemo.service;

import com.login.AuthDemo.web.dto.UserInfoDto;

public interface UserInfoService {
    String getPrincipalName();
    void save(UserInfoDto userInfoDto);
}
