package com.usmba.restau.Student.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class TicketRequest {
    private TypeRepas typeRepas;
    private String dateConsomation;
}
