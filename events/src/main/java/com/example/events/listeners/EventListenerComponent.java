package com.example.events.listeners;

import com.example.events.models.EventCreatedEvent; // Corrected import
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListenerComponent {

    private static final Logger logger = LoggerFactory.getLogger(EventListenerComponent.class);

    @EventListener
    public void handleEventCreated(EventCreatedEvent event) {
        logger.info("Event Created: {}", event.getEventDetails().getTitle());
        // You can add more logging or other actions here
    }
}