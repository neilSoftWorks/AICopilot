package com.example.applicationsystem.controllers;

import com.example.applicationsystem.models.BusinessDetails;
import com.example.applicationsystem.services.BusinessDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationSystemController {

    @Autowired
    private BusinessDetailsService businessDetailsService;

    @PostMapping
    public ResponseEntity<BusinessDetails> submitApplication(@RequestBody BusinessDetails businessDetails) {
        BusinessDetails savedBusinessDetails = businessDetailsService.submitApplication(businessDetails);
        return new ResponseEntity<>(savedBusinessDetails, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusinessDetails>> getAllBusinessDetails() {
        List<BusinessDetails> businessDetailsList = businessDetailsService.getAllBusinessDetails();
        return new ResponseEntity<>(businessDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessDetails> getBusinessDetailsById(@PathVariable Long id) {
        BusinessDetails businessDetails = businessDetailsService.getBusinessDetailsById(id);
        if (businessDetails != null) {
            return new ResponseEntity<>(businessDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessDetails> updateBusinessDetails(@PathVariable Long id, @RequestBody BusinessDetails businessDetails) {
        BusinessDetails updatedBusinessDetails = businessDetailsService.updateBusinessDetails(id, businessDetails);
        if (updatedBusinessDetails != null) {
            return new ResponseEntity<>(updatedBusinessDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusinessDetails(@PathVariable Long id) {
        businessDetailsService.deleteBusinessDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
