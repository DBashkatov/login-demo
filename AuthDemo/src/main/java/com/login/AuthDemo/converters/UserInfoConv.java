package com.login.AuthDemo.converters;

import com.login.AuthDemo.dto.UserInfoDto;
import com.login.AuthDemo.entities.UserInfo;
import com.login.AuthDemo.repository.EnrollmentRepository;
import com.login.AuthDemo.service.Impl.EnrollmentServiceImpl;
import com.login.AuthDemo.service.UserInfoService;
import com.login.AuthDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class UserInfoConv {

    @Autowired
    EnrollmentServiceImpl enrollmentService;
    @Autowired
    EnrollmentRepository enrollmentRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;

    public UserInfo userInfoFromDto(UserInfoDto userInfoDto) {
        System.out.println("UserInfoDto in userInfoFromDto: " + userInfoDto);

        UserInfo userInfo;
        if (userInfoService.getCurrentPrincipalUserInfo() != null) {
            userInfo = userInfoService.getCurrentPrincipalUserInfo();
        } else {
            userInfo = new UserInfo();
        }

        userInfo.setStudentStatus(userInfoDto.getStudentStatus());
        userInfo.setFirstName(userInfoDto.getFirstName());
        userInfo.setLastName(userInfoDto.getLastName());
        userInfo.setCity(userInfoDto.getCity());
        userInfo.setUniversity(userInfoDto.getUniversity());
        userInfo.setGrade(userInfoDto.getGrade());
        userInfo.setDepartment(userInfoDto.getDepartment());
        userInfo.setSpeciality(userInfoDto.getSpeciality());
        userInfo.setPhone(userInfoDto.getPhone());

        userInfo.setUser(userService.getCurrentPrincipalUser());
        if (userInfoDto.getEnrollmentId() != null)
            userInfo.setEnrollment(enrollmentRepository.findById(userInfoDto.getEnrollmentId()).get());

        return userInfo;
    }

    public UserInfoDto userInfoToDto(UserInfo userInfo) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        UserInfoDto userInfoDto = new UserInfoDto();

        userInfoDto.setStudentStatus(userInfo.getStudentStatus());
        userInfoDto.setFirstName(userInfo.getFirstName());
        userInfoDto.setLastName(userInfo.getLastName());
        userInfoDto.setCity(userInfo.getCity());
        userInfoDto.setUniversity(userInfo.getUniversity());
        userInfoDto.setDepartment(userInfo.getDepartment());
        userInfoDto.setSpeciality(userInfo.getSpeciality());
        userInfoDto.setGrade(userInfo.getGrade());
        userInfoDto.setPhone(userInfo.getPhone());

        if (userInfo.getEnrollment()!= null) {
            userInfoDto.setTestStart(userInfo.getEnrollment().getTestStart().format(format));
            userInfoDto.setTestEnd(userInfo.getEnrollment().getTestEnd().format(format));
            userInfoDto.setEnrollmentId(userInfo.getEnrollment().getId());
        }

        return userInfoDto;
    }
}
