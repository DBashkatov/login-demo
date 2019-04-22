package com.login.AuthDemo.service.Impl;

import com.login.AuthDemo.entities.Source;
import com.login.AuthDemo.repository.SourceRepository;
import com.login.AuthDemo.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceServiceImpl implements SourceService {

    @Autowired
    SourceRepository sourceRepository;

    @Override
    public List<Source> findAll() {
        return sourceRepository.findAll();
    }
}
