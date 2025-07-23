package com.rubensrangel.health_traceability.controllers;

import com.rubensrangel.health_traceability.model.EventMetadata;
import com.rubensrangel.health_traceability.model.EventPayload;
import com.rubensrangel.health_traceability.model.HealthEvent;
import com.rubensrangel.health_traceability.model.dto.EventRequest;
import com.rubensrangel.health_traceability.repository.HealthEventRepository;
import com.rubensrangel.health_traceability.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class HealthEventController {

    @Autowired
    private HealthEventRepository repository;

    @Autowired
    private KafkaProducerService kafkaProducer;

    @PostMapping
    public ResponseEntity<HealthEvent> createEvent(
            @RequestBody EventRequest request) {

        HealthEvent event = new HealthEvent();
        event.setEventType(request.getEventType());

        // Construir payload
        EventPayload payload = new EventPayload(
                request.getPacienteId(),
                request.getDetails()
        );
        event.setPayload(payload);

        // Construir metadata
        EventMetadata metadata = new EventMetadata();
        metadata.setUsuario(request.getUsuario());
        metadata.setDispositivo(request.getDispositivo());
        event.setMetadata(metadata);

        HealthEvent savedEvent = repository.save(event);
        kafkaProducer.sendHealthEvent(savedEvent.toString());

        return ResponseEntity.ok(savedEvent);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<HealthEvent>> getEventsByPatient(
            @PathVariable("patientId") String patientId) {

        List<HealthEvent> events = repository.findByPacienteId(patientId);
        return ResponseEntity.ok(events);
    }


}