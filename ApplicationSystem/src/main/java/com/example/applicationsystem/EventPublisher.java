package com.example.applicationsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    private static final Logger logger = LoggerFactory.getLogger(EventPublisher.class);
    @Autowired
    private JmsTemplate jmsTemplate;

    public void publishEvent(Object event) {
        jmsTemplate.convertAndSend("your-event-queue", event); // Replace with your queue name
        logger.info("Published event: {}", event);
    }
}