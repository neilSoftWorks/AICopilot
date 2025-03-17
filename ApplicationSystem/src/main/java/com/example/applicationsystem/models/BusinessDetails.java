package com.example.applicationsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BusinessDetails {
    @Id
    private Long id;
    private String name;
    private String contactDetails;
    private String address;
    private String industry;
    private String phoneNumber;
    private String financialInformation;
    private String emailAddress;
    private Long applicationStatusId;
    private String businessName;
    private String contactNumber;
    private String email;
    private String ownerName;
    private String businessType;
    private String registrationNumber;
}
