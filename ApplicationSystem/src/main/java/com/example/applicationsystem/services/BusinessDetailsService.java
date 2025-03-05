package com.example.applicationsystem.services;

import com.example.applicationsystem.models.BusinessDetails;
import com.example.applicationsystem.repositories.BusinessDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessDetailsService {
    @Autowired
    private BusinessDetailsRepository businessDetailsRepository;

    public List<BusinessDetails> getAllBusinessDetails() {
        return businessDetailsRepository.findAll();
    }

    public BusinessDetails getBusinessDetailsById(Long id) {
        return businessDetailsRepository.findById(id);
    }

    public BusinessDetails createBusinessDetails(BusinessDetails businessDetails) {
        return businessDetailsRepository.save(businessDetails);
    }

    public BusinessDetails updateBusinessDetails(Long id, BusinessDetails businessDetails) {
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