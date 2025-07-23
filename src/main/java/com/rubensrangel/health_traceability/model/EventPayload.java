package com.rubensrangel.health_traceability.model;

import lombok.Data;

import java.util.Map;

public class EventPayload {
    private String pacienteId;
    private Map<String, Object> details;

    public EventPayload(String pacienteId, Map<String, Object> details) {
        this.pacienteId = pacienteId;
        this.details = details;
    }

    public EventPayload() {
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }
}