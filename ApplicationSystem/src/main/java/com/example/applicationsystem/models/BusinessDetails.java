package com.example.applicationsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class BusinessDetails {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @NotBlank
 private String businessName;
 
 @NotBlank
 private String registrationNumber;
 
 @NotBlank
 private String businessType;
 
 public BusinessDetails() {}

 // Getters and Setters
 public Long getId() { return id; }
 public void setId(Long id) { this.id = id; }
 
 public String getBusinessName() { return businessName; }
 public void setBusinessName(String businessName) { this.businessName = businessName; }
 
 public String getRegistrationNumber() { return registrationNumber; }
 public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }
 
 public String getBusinessType() { return businessType; }
 public void setBusinessType(String businessType) { this.businessType = businessType; }
}
