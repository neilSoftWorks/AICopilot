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

    public Optional<BusinessDetails> getBusinessDetailsById(Long id) {
        return businessDetailsRepository.findById(id);
    }

    public BusinessDetails createBusinessDetails(BusinessDetails businessDetails) {
        return businessDetailsRepository.save(businessDetails);
    }

    public BusinessDetails updateBusinessDetails(BusinessDetails businessDetails) {
        return businessDetailsRepository.save(businessDetails);
    }

    public boolean deleteBusinessDetails(Long id) {
        if (businessDetailsRepository.existsById(id)) {
            businessDetailsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}