package com.example.applicationsystem.consumers;

import com.example.shared.SharedEventDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.apache.kafka.clients.consumer.ConsumerRecord;

@Component
public class BusinessDetailsConsumer {

    private static final Logger logger = LoggerFactory.getLogger(BusinessDetailsConsumer.class);

    @KafkaListener(topics = "test-topic", groupId = "business-details-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumeEvent(ConsumerRecord<String, SharedEventDetails> record) {
        SharedEventDetails eventDetails = record.value();
        logger.info("Received event from Events module: {}", eventDetails);
        // Process the event details
    }
}