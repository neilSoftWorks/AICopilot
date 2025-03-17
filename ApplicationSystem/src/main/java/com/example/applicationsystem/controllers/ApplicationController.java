package com.example.applicationsystem.controllers;

import com.example.applicationsystem.services.ApplicationService;
import com.example.shared.SharedEventDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Controller
@RequestMapping("/api/applications")
public class ApplicationController {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    @ResponseBody
    public List<SharedEventDetails> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/api/applications/edit/{id}")
    public String editApplication(@PathVariable Long id) {
        logger.info("Received Edit Request: {}", id);
        return "test"; // Return the view name
    }

    @GetMapping("/{id}")
    @ResponseBody
    public SharedEventDetails getApplication(@PathVariable Long id) {
        return applicationService.getApplicationById(id);
    }
}
