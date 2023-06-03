package com.usmba.restau.Student.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketResponse{
    private Integer id;
    private TypeRepas typeRepas;
    private Date dateConsomation;
    private String userName;
}