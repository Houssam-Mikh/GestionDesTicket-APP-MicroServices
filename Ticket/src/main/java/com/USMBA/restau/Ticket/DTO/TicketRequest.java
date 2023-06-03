package com.USMBA.restau.Ticket.DTO;

import com.USMBA.restau.Ticket.entities.TypeRepas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketRequest {
    private TypeRepas typeRepas;
    private String dateConsomation;
    private String userName;

}
