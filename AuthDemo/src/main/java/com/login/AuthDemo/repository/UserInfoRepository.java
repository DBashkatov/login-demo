package com.login.AuthDemo.repository;

import com.login.AuthDemo.entities.Enrollment;
import com.login.AuthDemo.entities.User;
import com.login.AuthDemo.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUser(User user);
}