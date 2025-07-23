package com.rubensrangel.health_traceability.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "health_events")
public class HealthEvent {
    @Id
    private String id;

    private String eventType;
    private EventPayload payload;
    private EventMetadata metadata;


    public HealthEvent(String id, String eventType, EventPayload payload, EventMetadata metadata) {
        this.id = id;
        this.eventType = eventType;
        this.payload = payload;
        this.metadata = metadata;
    }

    public HealthEvent() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public EventPayload getPayload() {
        return payload;
    }

    public void setPayload(EventPayload payload) {
        this.payload = payload;
    }

    public EventMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(EventMetadata metadata) {
        this.metadata = metadata;
    }
}