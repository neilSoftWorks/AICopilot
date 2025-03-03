package com.example.applicationsystem.controllers;

import com.example.applicationsystem.models.BusinessDetails;
import com.example.applicationsystem.services.BusinessDetailsService;
import com.example.events.BusinessDetailsCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/business-details")
public class ApplicationSystemController {
    @Autowired
    private BusinessDetailsService businessDetailsService;

    @Autowired
    private KafkaTemplate<String, BusinessDetailsCreated> kafkaTemplate;

    @GetMapping
    public List<BusinessDetails> getAllBusinessDetails() {
        return businessDetailsService.getAllBusinessDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessDetails> getBusinessDetailsById(@PathVariable("id") Long id) {
        Optional<BusinessDetails> businessDetails = businessDetailsService.getBusinessDetailsById(id);
        return businessDetails.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BusinessDetails> createBusinessDetails(@RequestBody BusinessDetails businessDetails) {
        BusinessDetails createdBusinessDetails = businessDetailsService.createBusinessDetails(businessDetails);

        // Publish the event to Kafka
        BusinessDetailsCreated event = new BusinessDetailsCreated(
                createdBusinessDetails.getId(),
                createdBusinessDetails.getName(),
                createdBusinessDetails.getAddress()
        );
        kafkaTemplate.send("business-details-created", event);

        return new ResponseEntity<>(createdBusinessDetails, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessDetails> updateBusinessDetails(@PathVariable("id") Long id, @RequestBody BusinessDetails businessDetails) {
        Optional<BusinessDetails> existingBusinessDetails = businessDetailsService.getBusinessDetailsById(id);
        if (existingBusinessDetails.isPresent()) {
            businessDetails.setId(id);
            return ResponseEntity.ok(businessDetailsService.updateBusinessDetails(businessDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusinessDetails(@PathVariable("id") Long id) {
        if (businessDetailsService.deleteBusinessDetails(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}