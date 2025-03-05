package com.example.applicationsystem.repositories;

import com.example.applicationsystem.models.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationStatusRepository extends JpaRepository<ApplicationStatus, Long> {
}