package com.example.applicationsystem.repository;

import com.example.applicationsystem.models.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationStatusRepository extends JpaRepository<ApplicationStatus, Long> {
    List<ApplicationStatus> findByBusinessDetailsIdOrderByCreatedAtDesc(Long businessDetailsId);
}