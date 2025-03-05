package com.example.applicationsystem.services;

import com.example.applicationsystem.events.BusinessDetailsCreatedEvent;
import com.example.applicationsystem.models.ApplicationStatus;
import com.example.applicationsystem.models.BusinessDetails;
import com.example.applicationsystem.repositories.ApplicationStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationService.class);

    @Autowired
    private BusinessDetailsService businessDetailsService;

    @Autowired
    private ApplicationStatusRepository applicationStatusRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public BusinessDetails submitApplication(BusinessDetails businessDetails) {
        BusinessDetails savedBusinessDetails = businessDetailsService.createBusinessDetails(businessDetails);

        ApplicationStatus initialStatus = new ApplicationStatus();
        initialStatus.setBusinessDetails(savedBusinessDetails);
        initialStatus.setStatus("Submitted");
        applicationStatusRepository.save(initialStatus);

        applicationEventPublisher.publishEvent(new BusinessDetailsCreatedEvent(this, savedBusinessDetails));

        return savedBusinessDetails;
    }

    public List<BusinessDetails> getAllBusinessDetails() {
        return businessDetailsService.getAllBusinessDetails();
    }

    public List<ApplicationStatus> getAllApplicationStatuses() {
        return applicationStatusRepository.findAll();
    }

    public ApplicationStatus getApplicationStatusById(Long id) {
        Optional<ApplicationStatus> applicationStatus = applicationStatusRepository.findById(id);
        return applicationStatus.orElse(null);
    }

    @Transactional
    public ApplicationStatus updateApplicationStatus(Long id, ApplicationStatus updatedApplicationStatus) {
        Optional<ApplicationStatus> existingApplicationStatus = applicationStatusRepository.findById(id);
        if (existingApplicationStatus.isPresent()) {
            updatedApplicationStatus.setId(id);
            return applicationStatusRepository.save(updatedApplicationStatus);
        }
        return null;
    }

    @Transactional
    public void deleteApplicationStatus(Long id) {
        applicationStatusRepository.deleteById(id);
    }
}
