package com.rubensrangel.health_traceability.repository;


import com.rubensrangel.health_traceability.model.HealthEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface HealthEventRepository extends MongoRepository<HealthEvent, String> {

    @Query("{'payload.pacienteId': ?0}")
    List<HealthEvent> findByPacienteId(String pacienteId);
}