package com.example.shared;

import lombok.Data;

@Data
public class SharedEventDetails {
    private Long id;
    private String title;
    private String date;
    private String location;
    private String businessName;
    private String contactNumber;
    private String email;
    private String ownerName;
    private String businessType;
    private String registrationNumber;
    private Long applicationStatusId;
}
