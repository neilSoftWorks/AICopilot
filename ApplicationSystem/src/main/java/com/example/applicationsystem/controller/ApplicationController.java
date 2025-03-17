package com.example.applicationsystem.controller;

import com.example.applicationsystem.services.ApplicationService;
import com.example.shared.SharedEventDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<SharedEventDetails> getAllApplications() {
        return applicationService.getAllApplications();
    }
}
