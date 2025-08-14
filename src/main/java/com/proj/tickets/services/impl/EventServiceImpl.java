package com.proj.tickets.services.impl;

import com.proj.tickets.domain.CreateEventRequest;
import com.proj.tickets.domain.entities.Event;
import com.proj.tickets.domain.entities.TicketType;
import com.proj.tickets.domain.entities.User;
import com.proj.tickets.exceptions.UserNotFoundException;
import com.proj.tickets.repositories.EventRepository;
import com.proj.tickets.repositories.UserRepository;
import com.proj.tickets.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public Event createEvent(UUID organizerId, CreateEventRequest event) {
       User organizer = userRepository.findById(organizerId)
               .orElseThrow(()->new UserNotFoundException(String.format("user with id %s not found",organizerId)));

        List<TicketType> ticketTypesToCreate = event.getTicketTypes().stream().map(
                ticketType -> {
                    TicketType ticketTypeToCreate = new TicketType();
                    ticketTypeToCreate.setName(ticketType.getName());
                    ticketTypeToCreate.setPrice(ticketType.getPrice());
                    ticketTypeToCreate.setTotalAvailable(ticketType.getTotalAvailable());
                    ticketTypeToCreate.setDescription(ticketType.getDescription());
//                    ticketTypeToCreate.setEvent(null);
                    return ticketTypeToCreate;
                }).toList();

        Event eventToCreate=new Event();
       eventToCreate.setName(event.getName());
       eventToCreate.setStart(event.getStart());
       eventToCreate.setEnd(event.getEnd());
       eventToCreate.setVenue(event.getVenue());
       eventToCreate.setSaleStart(event.getSaleStart());
       eventToCreate.setSaleEnd(event.getSaleEnd());
       eventToCreate.setStatus(event.getStatus());
       eventToCreate.setOrganizer(organizer);
       eventToCreate.setTicketTypes(ticketTypesToCreate);

       return eventRepository.save(eventToCreate);
    }
}
