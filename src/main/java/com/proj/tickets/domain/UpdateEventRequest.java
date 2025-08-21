package com.proj.tickets.domain;

import com.proj.tickets.domain.entities.EventStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEventRequest {

    private UUID id;
    private String name;
    private String venue;
    private LocalDateTime start;
    private LocalDateTime end;
    private LocalDateTime saleStart;
    private LocalDateTime saleEnd;
    private EventStatusEnum status;
    private List<UpdateTicketTypeRequest> ticketTypes=new ArrayList<>();
}
