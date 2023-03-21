package com.example.airplanetest.repository;

import com.example.airplanetest.model.Airplane;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AirplaneRepository extends MongoRepository<Airplane, Long> {
}
