package com.example.applicationsystem.models;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

@Entity
@Table(name = "application_status")
@Data
public class ApplicationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "business_id")
    private Long businessId;

    @Column(name = "status_name")
    private String statusName;

    @ManyToOne
    @JoinColumn(name = "business_details_id")
    @JsonIgnore // Add this annotation to break the circular reference
    private BusinessDetails businessDetails;

    // Constructors, getters, and setters (using Lombok's @Data)
}