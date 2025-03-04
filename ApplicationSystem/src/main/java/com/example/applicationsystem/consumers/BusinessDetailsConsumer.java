package com.example.applicationsystem.consumers;

import com.example.events.Event;
import com.example.events.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class BusinessDetailsConsumer {

    private final EventHandler eventHandler;

    public BusinessDetailsConsumer(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public void receive(Event event) {
        eventHandler.handle(event);
    }
}