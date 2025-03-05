package com.example.applicationsystem.controller;

import com.example.applicationsystem.models.BusinessDetails;
import com.example.applicationsystem.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<List<BusinessDetails>> getAllBusinessDetailsWithApplicationStatus() {
        List<BusinessDetails> businessDetails = applicationService.getAllBusinessDetailsWithApplicationStatus();
        return ResponseEntity.ok(businessDetails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessDetails> getApplicationById(@PathVariable Long id) {
        BusinessDetails businessDetails = applicationService.getBusinessDetailsById(id);
        if (businessDetails != null) {
            return ResponseEntity.ok(businessDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessDetails> updateApplication(@PathVariable Long id, @RequestBody BusinessDetails updatedBusinessDetails) {
        BusinessDetails updated = applicationService.updateBusinessDetails(id, updatedBusinessDetails); // Implement updateBusinessDetails in ApplicationService
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}