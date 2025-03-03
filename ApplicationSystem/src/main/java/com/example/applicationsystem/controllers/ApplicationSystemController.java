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
import java.util.UUID;

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
    public ResponseEntity<BusinessDetails> getBusinessDetailsById(@PathVariable("id") UUID id) {
        return businessDetailsService.getBusinessDetailsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BusinessDetails> createBusinessDetails(@RequestBody BusinessDetails businessDetails) {
        businessDetails.setId(UUID.randomUUID());
        BusinessDetails createdBusinessDetails = businessDetailsService.createBusinessDetails(businessDetails);

        // Publish the event to Kafka
        BusinessDetailsCreated event = new BusinessDetailsCreated(
                createdBusinessDetails.getId().toString(),
                createdBusinessDetails.getName(),
                createdBusinessDetails.getAddress()
        );
        kafkaTemplate.send("business-details-created", event);

        return new ResponseEntity<>(createdBusinessDetails, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessDetails> updateBusinessDetails(@PathVariable("id") UUID id, @RequestBody BusinessDetails businessDetails) {
        return businessDetailsService.getBusinessDetailsById(id)
                .map(existingBusinessDetails -> {
                    businessDetails.setId(id);
                    return ResponseEntity.ok(businessDetailsService.updateBusinessDetails(businessDetails));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusinessDetails(@PathVariable("id") UUID id) {
        if (businessDetailsService.deleteBusinessDetails(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}