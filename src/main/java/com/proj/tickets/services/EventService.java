package com.proj.tickets.services;

import com.proj.tickets.domain.CreateEventRequest;
import com.proj.tickets.domain.entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface EventService {

    Event createEvent(UUID organizerId, CreateEventRequest event);
    Page listEventsForOrganizer(UUID organizerId, Pageable pageable);
    Optional<Event> getEventForOrganizer(UUID organizerId, UUID id);
}
