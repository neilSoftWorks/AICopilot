package com.example.applicationsystem.controllers;

import com.example.events.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationSystemController {

    @GetMapping("/test")
    public String testEndpoint() {
        Event event = new Event("Test event from ApplicationSystemController");
        event.send();
        return "Test endpoint called";
    }
}