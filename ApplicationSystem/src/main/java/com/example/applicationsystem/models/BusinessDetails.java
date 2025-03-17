package com.example.applicationsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "business_details")
@Data
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
