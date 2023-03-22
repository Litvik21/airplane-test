package com.example.airplanetest.service.impl;

import com.example.airplanetest.model.Airplane;
import com.example.airplanetest.repository.AirplaneRepository;
import com.example.airplanetest.service.AirplaneService;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository repository;

    public AirplaneServiceImpl(AirplaneRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Airplane airplane) {
        repository.save(airplane);
    }
}
