package com.example.applicationsystem.services;

import com.example.applicationsystem.EventPublisher;
import com.example.applicationsystem.models.BusinessDetails;
import com.example.applicationsystem.repositories.BusinessDetailsRepository;
import com.example.shared.SharedEventDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationService.class);

    @Autowired
    private BusinessDetailsRepository businessDetailsRepository;

    @Autowired // Inject EventPublisher
    private EventPublisher eventPublisher;

    public List<BusinessDetails> getAllBusinessDetailsWithApplicationStatus() {
        return businessDetailsRepository.findAllBusinessDetailsWithApplicationStatus();
    }

    public BusinessDetails getBusinessDetailsById(Long id) {
        Optional<BusinessDetails> optionalBusinessDetails = businessDetailsRepository.findById(id);
        return optionalBusinessDetails.orElse(null);
    }

    @Transactional // Add Transactional annotation
    public BusinessDetails updateBusinessDetails(Long id, BusinessDetails updatedBusinessDetails) {
        Optional<BusinessDetails> optionalBusinessDetails = businessDetailsRepository.findById(id);
        if (optionalBusinessDetails.isPresent()) {
            updatedBusinessDetails.setId(id); // Ensure the ID is set
            BusinessDetails updated = businessDetailsRepository.save(updatedBusinessDetails);

            // Publish event *after* successful save
            try {
                SharedEventDetails eventDetails = new SharedEventDetails();
                eventDetails.setId(id); // Or populate with relevant data from 'updated'
                eventDetails.setTitle("Application Updated");
                eventPublisher.publishEvent(eventDetails);
                logger.info("Published 'Application Updated' event for ID: {}", id);
            } catch (Exception e) {
                // Handle event publishing error (log it, etc.)
                logger.error("Error publishing 'Application Updated' event for ID: {}", id, e);
                // Consider whether to rethrow the exception or not (depends on your requirements)
            }

            return updated;
        } else {
            return null;
        }

    }
}