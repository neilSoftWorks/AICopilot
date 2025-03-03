package com.example.applicationsystem.consumers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class BusinessDetailsConsumer {

    @JmsListener(destination = "business-details-queue")
    public void receiveBusinessDetails(String message) { // Adjust message type if needed
        // Process the message received from ActiveMQ
        System.out.println("Received Business Details: " + message);
        // Your processing logic here
    }
}