package com.example.applicationsystem;

import com.example.shared.SharedEventDetails; // Import from Shared module
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {

    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    @KafkaListener(topics = "test-topic", groupId = "application-system-group")
    public void consumeEvent(SharedEventDetails eventDetails) {
        logger.info("Received event from Events module: {}", eventDetails);
        // Process the event data
    }
}