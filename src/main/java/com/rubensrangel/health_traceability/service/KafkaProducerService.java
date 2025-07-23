package com.rubensrangel.health_traceability.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final String TOPIC = "health-events";
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendHealthEvent(String event) {
        kafkaTemplate.send(TOPIC, event);
    }
}