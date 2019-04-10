package com.login.AuthDemo.repository;

import com.login.AuthDemo.model.User;
import com.login.AuthDemo.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUser(User user);
}