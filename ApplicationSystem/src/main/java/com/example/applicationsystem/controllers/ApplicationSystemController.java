package com.example.applicationsystem.controllers;

import com.example.models.BusinessDetails; // Correct import
import com.example.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationSystemController { // Correct class name

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<BusinessDetails> submitApplication(@RequestBody BusinessDetails businessDetails) {
        BusinessDetails savedBusinessDetails = applicationService.submitApplication(businessDetails);
        return new ResponseEntity<>(savedBusinessDetails, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusinessDetails>> getAllBusinessDetails() {
        List<BusinessDetails> businessDetailsList = applicationService.getAllBusinessDetails();
        return new ResponseEntity<>(businessDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessDetails> getBusinessDetailsById(@PathVariable Long id) {
        BusinessDetails businessDetails = applicationService.getBusinessDetailsById(id);
        if (businessDetails != null) {
            return new ResponseEntity<>(businessDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessDetails> updateBusinessDetails(@PathVariable Long id, @RequestBody BusinessDetails businessDetails) {
        BusinessDetails updatedBusinessDetails = applicationService.updateBusinessDetails(id, businessDetails);
        if (updatedBusinessDetails != null) {
            return new ResponseEntity<>(updatedBusinessDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusinessDetails(@PathVariable Long id) {
        applicationService.deleteBusinessDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
