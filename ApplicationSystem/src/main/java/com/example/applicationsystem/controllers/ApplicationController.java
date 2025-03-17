package com.example.applicationsystem.controllers;

import com.example.applicationsystem.services.ApplicationService;
import com.example.shared.SharedEventDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    @ResponseBody
    public List<SharedEventDetails> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/edit/{id}")
    public void editApplication(@PathVariable Long id) {

    }

    @GetMapping("/{id}")
    @ResponseBody
    public SharedEventDetails getApplication(@PathVariable Long id) {
        return applicationService.getApplicationById(id);
    }
}
