package com.example.applicationsystem.repositories;

import com.example.applicationsystem.models.BusinessDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessDetailsRepository extends JpaRepository<BusinessDetails, Long> {

    @Query("SELECT b FROM BusinessDetails b LEFT JOIN ApplicationStatus s ON s.businessDetails.id = b.id AND s.createdAt = (SELECT MAX(s2.createdAt) FROM ApplicationStatus s2 WHERE s2.businessDetails.id = b.id)")
    List<BusinessDetails> findAllBusinessDetailsWithApplicationStatus();
}