package com.example.applicationsystem.consumers;

import com.example.shared.SharedEventDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BusinessDetailsConsumer {

    private static final Logger logger = LoggerFactory.getLogger(BusinessDetailsConsumer.class);

    @KafkaListener(topics = "events-topic", groupId = "business-details-group")
    public void consumeEvent(SharedEventDetails eventDetails) {
        logger.info("Received event from Events module: {}", eventDetails);
        // Process the event data
    }
}
