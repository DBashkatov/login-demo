package com.login.AuthDemo.repository;

import com.login.AuthDemo.entities.TestFormat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestFormatRepository extends JpaRepository<TestFormat, Long> {
}