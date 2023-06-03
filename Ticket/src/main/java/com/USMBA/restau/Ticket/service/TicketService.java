package com.USMBA.restau.Ticket.service;

import com.USMBA.restau.Ticket.DTO.TicketRequest;
import com.USMBA.restau.Ticket.entities.Ticket;
import com.USMBA.restau.Ticket.repositories.TicektRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicektRepository repository;

    public void createTicket(TicketRequest request) throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date date= format.parse(request.getDateConsomation());
        Ticket ticket=new Ticket(null,request.getTypeRepas(),date,request.getUserName());
        repository.save(ticket);
    }

    public void deleteTicket(Integer id) {
        repository.deleteById(id);
    }

    public List<Ticket> getAllTickets() {
        return repository.findAll();
    }
    public List<Ticket> getTicketByDate(Date date){
        return repository.findByDateConsomation(date);
    }

    public List<Ticket> findTicketByUsername(String username) {
        return repository.findAllByUserName(username);
    }

    public Ticket findOneTicket(Integer id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("ticket doesn't exist"));
    }
}
