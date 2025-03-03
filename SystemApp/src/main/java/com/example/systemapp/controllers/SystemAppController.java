package com.example.systemapp.controllers;

import com.example.events.BusinessDetailsCreated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemAppController {

    private static final Logger logger = LoggerFactory.getLogger(SystemAppController.class);

    @KafkaListener(topics = "business-details-created", groupId = "system-app-group")
    public void listenForBusinessDetailsCreated(BusinessDetailsCreated event) {
        logger.info("Received BusinessDetailsCreated event: {}", event);
        // Process the event (e.g., update a database, send a notification)
    }
}