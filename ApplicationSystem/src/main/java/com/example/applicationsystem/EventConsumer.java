package com.example.applicationsystem;

import com.example.events.Event;
import com.example.events.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {

    private final EventHandler eventHandler;

    public EventConsumer(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public void receive(Event event) {
        eventHandler.handle(event);
    }
}