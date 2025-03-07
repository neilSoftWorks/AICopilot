package com.example.events.services;

import com.example.events.models.EventCreatedEvent;
import com.example.events.models.EventDetails; // Corrected import
import com.example.events.repositories.EventDetailsRepository; // Corrected import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventDetailsRepository eventDetailsRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public List<EventDetails> getAllEvents() {
        return eventDetailsRepository.findAll();
    }

    public EventDetails getEventById(Long id) {
        Optional<EventDetails> optionalEventDetails = eventDetailsRepository.findById(id);
        return optionalEventDetails.orElse(null);
    }

    public EventDetails createEvent(EventDetails eventDetails) {
        EventDetails createdEvent = eventDetailsRepository.save(eventDetails);
        eventPublisher.publishEvent(new EventCreatedEvent(this, createdEvent));
        return createdEvent;
    }

    public EventDetails updateEvent(Long id, EventDetails updatedEventDetails) {
        Optional<EventDetails> optionalEventDetails = eventDetailsRepository.findById(id);
        if (optionalEventDetails.isPresent()) {
            updatedEventDetails.setId(id);
            return eventDetailsRepository.save(updatedEventDetails);
        } else {
            return null;
        }
    }

    public void deleteEvent(Long id) {
        eventDetailsRepository.deleteById(id);
    }
}