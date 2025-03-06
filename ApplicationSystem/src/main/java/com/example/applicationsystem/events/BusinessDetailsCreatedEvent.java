package com.example.applicationsystem.events;

import com.example.applicationsystem.models.BusinessDetails;
import org.springframework.context.ApplicationEvent;

public class BusinessDetailsCreatedEvent extends ApplicationEvent {

    private BusinessDetails businessDetails;

    public BusinessDetailsCreatedEvent(Object source, BusinessDetails businessDetails) {
        super(source);
        this.businessDetails = businessDetails;
    }

    public BusinessDetails getBusinessDetails() {
        return businessDetails;
    }
}
