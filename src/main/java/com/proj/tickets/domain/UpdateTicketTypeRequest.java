package com.proj.tickets.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTicketTypeRequest {

    private UUID id;
    private String name;
    private String description;
    private Double price;
    private Integer totalAvailable;
}
