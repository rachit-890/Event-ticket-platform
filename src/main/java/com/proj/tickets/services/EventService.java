package com.proj.tickets.services;

import com.proj.tickets.domain.CreateEventRequest;
import com.proj.tickets.domain.entities.Event;

import java.util.UUID;

public interface EventService {

    Event createEvent(UUID organizerId, CreateEventRequest event);
}
