package com.proj.tickets.domain.dto;

import com.proj.tickets.domain.entities.EventStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEventDetailsResponseDto {

    private UUID id;
    private String name;
    private String venue;
    private LocalDateTime saleStart;
    private LocalDateTime saleEnd;
    private EventStatusEnum status;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<GetEventDetailsTicketTypeResponseDto> ticketTypes=new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
