package com.example.applicationsystem.services;

import com.example.applicationsystem.models.ApplicationStatus;
import com.example.applicationsystem.repository.ApplicationStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationStatusService {

    @Autowired
    private ApplicationStatusRepository applicationStatusRepository;

    public ApplicationStatus getLatestApplicationStatus(Long businessDetailsId) {
        List<ApplicationStatus> statuses = applicationStatusRepository.findByBusinessDetailsIdOrderByCreatedAtDesc(businessDetailsId);
        if (statuses != null && !statuses.isEmpty()) {
            return statuses.get(0);
        } else {
            return null;
        }
    }
}