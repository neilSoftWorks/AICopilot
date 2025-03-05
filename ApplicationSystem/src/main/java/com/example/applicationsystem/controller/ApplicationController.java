package com.example.applicationsystem.controller;

import com.example.applicationsystem.models.BusinessDetails;
import com.example.applicationsystem.models.ApplicationStatus;
import com.example.applicationsystem.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<BusinessDetails> submitApplication(@RequestBody BusinessDetails businessDetails) {
        BusinessDetails submittedDetails = applicationService.submitApplication(businessDetails);
        return new ResponseEntity<>(submittedDetails, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusinessDetails>> getAllBusinessDetails() {
        List<BusinessDetails> details = applicationService.getAllBusinessDetails();
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationStatus> getApplicationStatusById(@PathVariable Long id) {
        ApplicationStatus status = applicationService.getApplicationStatusById(id);
        if (status != null) {
            return new ResponseEntity<>(status, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationStatus> updateApplicationStatus(@PathVariable Long id, @RequestBody ApplicationStatus updatedStatus) {
        ApplicationStatus updated = applicationService.updateApplicationStatus(id, updatedStatus);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicationStatus(@PathVariable Long id) {
        applicationService.deleteApplicationStatus(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
