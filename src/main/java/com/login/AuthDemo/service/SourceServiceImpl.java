package com.login.AuthDemo.service;

import com.login.AuthDemo.model.Source;
import com.login.AuthDemo.repository.SourceRepository;
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
