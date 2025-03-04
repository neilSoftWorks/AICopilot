package com.example.applicationsystem;

import com.example.events.Event;
import com.example.events.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    private final EventHandler eventHandler;

    public EventPublisher(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public void publish(Event event) {
        event.send();
    }
}