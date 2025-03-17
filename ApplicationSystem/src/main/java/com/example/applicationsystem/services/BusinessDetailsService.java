package com.example.applicationsystem.services;

import com.example.applicationsystem.models.BusinessDetails;
import com.example.applicationsystem.repository.BusinessDetailsRepository;
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

    public BusinessDetails getBusinessDetailsByApplicationId(Long applicationId) {
        return businessDetailsRepository.findById(applicationId).orElse(null);
    }
}
