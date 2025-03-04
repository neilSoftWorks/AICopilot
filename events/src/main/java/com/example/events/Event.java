package com.example.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Event {

    private static final Logger logger = LoggerFactory.getLogger(Event.class);

    private String message;

    public Event(String message) {
        this.message = message;
    }

    public void send() {
        logger.info("Sending event: {}", message);
    }

    public String getMessage() {
        return message;
    }
}