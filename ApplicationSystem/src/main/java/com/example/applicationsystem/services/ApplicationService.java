package com.example.applicationsystem.services;

import com.example.applicationsystem.models.BusinessDetails;
import com.example.applicationsystem.repositories.BusinessDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private BusinessDetailsRepository businessDetailsRepository;

    public List<BusinessDetails> getAllBusinessDetailsWithApplicationStatus() {
        return businessDetailsRepository.findAllBusinessDetailsWithApplicationStatus();
    }

    public BusinessDetails getBusinessDetailsById(Long id) {
        Optional<BusinessDetails> optionalBusinessDetails = businessDetailsRepository.findById(id);
        return optionalBusinessDetails.orElse(null);
    }

    public BusinessDetails updateBusinessDetails(Long id, BusinessDetails updatedBusinessDetails) {
        Optional<BusinessDetails> optionalBusinessDetails = businessDetailsRepository.findById(id);
        if (optionalBusinessDetails.isPresent()) {
            updatedBusinessDetails.setId(id); // Ensure the ID is set
            return businessDetailsRepository.save(updatedBusinessDetails);
        } else {
            return null;
        }
    }
}