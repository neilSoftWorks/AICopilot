package com.example.events.models;

import org.springframework.context.ApplicationEvent;

public class EventCreatedEvent extends ApplicationEvent {

    private final EventDetails eventDetails; // Corrected import

    public EventCreatedEvent(Object source, EventDetails eventDetails) {
        super(source);
        this.eventDetails = eventDetails;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }
}