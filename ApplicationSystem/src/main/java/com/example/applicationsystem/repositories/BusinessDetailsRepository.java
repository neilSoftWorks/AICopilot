package com.example.applicationsystem.repositories;

import com.example.applicationsystem.models.BusinessDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BusinessDetailsRepository extends JpaRepository<BusinessDetails, UUID> {
}