package com.example.applicationsystem.services;

import com.example.applicationsystem.models.BusinessDetails;

import com.example.applicationsystem.repository.BusinessDetailsRepository;
import com.example.shared.SharedEventDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private BusinessDetailsRepository businessDetailsRepository;

    public SharedEventDetails getApplicationById(Long id) {
        BusinessDetails businessDetails = businessDetailsRepository.findById(id).orElse(null);
        if (businessDetails != null) {
            SharedEventDetails sharedEventDetails = new SharedEventDetails();
            sharedEventDetails.setId(businessDetails.getId());
            sharedEventDetails.setName(businessDetails.getName());
            sharedEventDetails.setContactDetails(businessDetails.getContactDetails());
            sharedEventDetails.setAddress(businessDetails.getAddress());
            sharedEventDetails.setIndustry(businessDetails.getIndustry());
            sharedEventDetails.setPhoneNumber(businessDetails.getPhoneNumber());
            sharedEventDetails.setFinancialInformation(businessDetails.getFinancialInformation());
            sharedEventDetails.setEmailAddress(businessDetails.getEmailAddress());
            sharedEventDetails.setApplicationStatusId(businessDetails.getApplicationStatusId());
            sharedEventDetails.setBusinessName(businessDetails.getBusinessName());
            sharedEventDetails.setContactNumber(businessDetails.getContactNumber());
            sharedEventDetails.setEmail(businessDetails.getEmail());
            sharedEventDetails.setOwnerName(businessDetails.getOwnerName());
            sharedEventDetails.setBusinessType(businessDetails.getBusinessType());
            sharedEventDetails.setRegistrationNumber(businessDetails.getRegistrationNumber());
            return sharedEventDetails;
        }
        return null;
    }

    public List<SharedEventDetails> getAllApplications() {
        List<BusinessDetails> businessDetailsList = businessDetailsRepository.findAll();
        List<SharedEventDetails> sharedEventDetailsList = new ArrayList<>();
        for (BusinessDetails businessDetails : businessDetailsList) {
            SharedEventDetails sharedEventDetails = new SharedEventDetails();
            sharedEventDetails.setId(businessDetails.getId());
            sharedEventDetails.setName(businessDetails.getName());
            sharedEventDetails.setContactDetails(businessDetails.getContactDetails());
            sharedEventDetails.setAddress(businessDetails.getAddress());
            sharedEventDetails.setIndustry(businessDetails.getIndustry());
            sharedEventDetails.setPhoneNumber(businessDetails.getPhoneNumber());
            sharedEventDetails.setFinancialInformation(businessDetails.getFinancialInformation());
            sharedEventDetails.setEmailAddress(businessDetails.getEmailAddress());
            sharedEventDetails.setApplicationStatusId(businessDetails.getApplicationStatusId());
            sharedEventDetails.setBusinessName(businessDetails.getBusinessName());
            sharedEventDetails.setContactNumber(businessDetails.getContactNumber());
            sharedEventDetails.setEmail(businessDetails.getEmail());
            sharedEventDetails.setOwnerName(businessDetails.getOwnerName());
            sharedEventDetails.setBusinessType(businessDetails.getBusinessType());
            sharedEventDetails.setRegistrationNumber(businessDetails.getRegistrationNumber());
            sharedEventDetailsList.add(sharedEventDetails);
        }
        return sharedEventDetailsList;
    }
}
