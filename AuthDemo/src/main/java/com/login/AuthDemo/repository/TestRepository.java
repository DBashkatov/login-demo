package com.login.AuthDemo.repository;

import com.login.AuthDemo.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
