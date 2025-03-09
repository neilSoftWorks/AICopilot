package com.example.applicationsystem.consumers;

import com.example.shared.SharedEventDetails;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

@Component
public class BusinessDetailsConsumer {

    private static final Logger logger = LoggerFactory.getLogger(BusinessDetailsConsumer.class);
    private final ConsumerFactory<String, SharedEventDetails> consumerFactory;

    @Autowired
    public BusinessDetailsConsumer(
            @Qualifier("consumerFactory") ConsumerFactory<String, SharedEventDetails> consumerFactory) {
        this.consumerFactory = consumerFactory;
    }

    @KafkaListener(topics = "events-topic", groupId = "business-details-group")
    public void consumeEvent(ConsumerRecord<String, SharedEventDetails> record) {
        SharedEventDetails eventDetails = record.value();
        logger.info("Received event from Events module: {}", eventDetails);
        // Process the event details
    }
}