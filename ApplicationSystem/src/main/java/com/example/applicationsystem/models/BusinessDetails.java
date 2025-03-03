package com.example.applicationsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BusinessDetails {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTACT_DETAILS")
    private String contactDetails;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "INDUSTRY")
    private String industry;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "FINANCIAL_INFORMATION")
    private String financialInformation;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
}