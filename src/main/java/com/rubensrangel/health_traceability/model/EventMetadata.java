package com.rubensrangel.health_traceability.model;


import java.time.Instant;


public class EventMetadata {
    private Instant timestamp;
    private String usuario;
    private String dispositivo;

    public EventMetadata() {
        this.timestamp = Instant.now();
    }

    public EventMetadata(String usuario, String dispositivo) {
        this();
        this.usuario = usuario;
        this.dispositivo = dispositivo;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }
}