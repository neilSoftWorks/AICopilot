package com.example.applicationsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {

    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    @JmsListener(destination = "SoftWorks")
    public void receiveEvent(Object event) {
        logger.info("Received event: {}", event);
        // Process the received event
        System.out.println("Received event: " + event);
    }
}
