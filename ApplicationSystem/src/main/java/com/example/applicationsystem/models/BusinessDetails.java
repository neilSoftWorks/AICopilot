package com.example.applicationsystem.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class BusinessDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String contactDetails;
    private String phoneNumber;
    private String emailAddress;
    private String industry;
    private String financialInformation;

    @OneToMany(mappedBy = "businessDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<ApplicationStatus> applicationStatus; // Changed back to applicationStatus

    // Constructors, getters and setters
    public BusinessDetails() {
    }

    public BusinessDetails(String name, String address, String contactDetails, String phoneNumber, String emailAddress, String industry, String financialInformation) {
        this.name = name;
        this.address = address;
        this.contactDetails = contactDetails;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.industry = industry;
        this.financialInformation = financialInformation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getFinancialInformation() {
        return financialInformation;
    }

    public void setFinancialInformation(String financialInformation) {
        this.financialInformation = financialInformation;
    }

    public List<ApplicationStatus> getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(List<ApplicationStatus> applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}