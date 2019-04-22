package com.login.AuthDemo.repository;

import com.login.AuthDemo.entities.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestUserRepository extends JpaRepository<TestUser, Long>{
}