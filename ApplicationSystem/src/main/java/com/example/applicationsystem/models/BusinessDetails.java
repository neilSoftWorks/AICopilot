package com.example.applicationsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BusinessDetails {
    @Id
    private Long id;
    private String businessName;
    private String contactNumber;
    private String email;
    private String ownerName;
    private String businessType;
    private String registrationNumber;
    private Long applicationStatusId;
}