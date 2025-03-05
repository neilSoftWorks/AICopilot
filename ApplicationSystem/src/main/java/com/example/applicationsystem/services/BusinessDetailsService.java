package com.example.applicationsystem.services;

import com.example.applicationsystem.models.BusinessDetails;
import com.example.applicationsystem.repositories.BusinessDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessDetailsService {

    @Autowired
    private BusinessDetailsRepository businessDetailsRepository;

    public List<BusinessDetails> getAllBusinessDetails() {
        return businessDetailsRepository.findAll();
    }

    public BusinessDetails getBusinessDetailsById(Long id) {
        Optional<BusinessDetails> businessDetails = businessDetailsRepository.findById(id);
        return businessDetails.orElse(null);
    }

    public BusinessDetails createBusinessDetails(BusinessDetails businessDetails) {
        return businessDetailsRepository.save(businessDetails);
    }

    public BusinessDetails updateBusinessDetails(Long id, BusinessDetails updatedBusinessDetails) {
        Optional<BusinessDetails> existingBusinessDetails = businessDetailsRepository.findById(id);
        if (existingBusinessDetails.isPresent()) {
            updatedBusinessDetails.setId(id);
            return businessDetailsRepository.save(updatedBusinessDetails);
        }
        return null;
    }

    public void deleteBusinessDetails(Long id) {
        businessDetailsRepository.deleteById(id);
    }
}
