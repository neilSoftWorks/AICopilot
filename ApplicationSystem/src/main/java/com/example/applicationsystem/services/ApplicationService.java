package com.example.applicationsystem.services;

import com.example.applicationsystem.models.ApplicationStatus;
import com.example.applicationsystem.models.BusinessDetails;
import com.example.shared.SharedEventDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private BusinessDetailsService businessDetailsService;

    @Autowired
    private ApplicationStatusService applicationStatusService;

    public List<SharedEventDetails> getAllApplications() {
        List<BusinessDetails> businessDetailsList = businessDetailsService.getAllBusinessDetails();
        List<SharedEventDetails> sharedEventDetailsList = new ArrayList<>();
        for (BusinessDetails businessDetails : businessDetailsList) {
            SharedEventDetails sharedEventDetails = new SharedEventDetails();
            sharedEventDetails.setId(businessDetails.getId());
            sharedEventDetails.setBusinessName(businessDetails.getBusinessName());
            sharedEventDetails.setContactNumber(businessDetails.getContactNumber());
            sharedEventDetails.setEmail(businessDetails.getEmail());
            sharedEventDetails.setOwnerName(businessDetails.getOwnerName());
            sharedEventDetails.setBusinessType(businessDetails.getBusinessType());
            sharedEventDetails.setRegistrationNumber(businessDetails.getRegistrationNumber());
            ApplicationStatus latestStatus = applicationStatusService.getLatestApplicationStatus(businessDetails.getId());
            if (latestStatus != null) {
                sharedEventDetails.setApplicationStatusId(latestStatus.getId());
            } else {
                sharedEventDetails.setApplicationStatusId(null);
            }
            sharedEventDetailsList.add(sharedEventDetails);
        }
        return sharedEventDetailsList;
    }
}
