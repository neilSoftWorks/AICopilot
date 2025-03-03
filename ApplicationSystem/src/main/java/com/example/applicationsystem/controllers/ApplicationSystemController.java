package com.example.applicationsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationSystemController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/send")
    public String sendMessage() {
        jmsTemplate.convertAndSend("myQueue", "Hello from ApplicationSystem!");
        return "Message sent!";
    }
}