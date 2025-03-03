package com.example.applicationsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class BusinessDetails {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String address;
}