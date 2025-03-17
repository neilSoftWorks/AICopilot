package com.example.applicationsystem.repository;

import com.example.applicationsystem.models.BusinessDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessDetailsRepository extends JpaRepository<BusinessDetails, Long> {
}
