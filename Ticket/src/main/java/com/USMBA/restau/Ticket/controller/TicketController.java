package com.USMBA.restau.Ticket.controller;

import com.USMBA.restau.Ticket.DTO.TicketRequest;
import com.USMBA.restau.Ticket.entities.Ticket;
import com.USMBA.restau.Ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
@Slf4j
public class TicketController {

    private final TicketService ticketService;
    //this method is generated to make student able to create a new ticket
    @PostMapping("/create")
    public void createTicket(@RequestBody TicketRequest request) throws ParseException {
        ticketService.createTicket(request);
    }
    //this method is generated to make student and controller able to delete a ticket
    @DeleteMapping("/delete/{id}")
    public Integer deleteTicket(@PathVariable Integer id){
            ticketService.deleteTicket(id);
        return id;
    }
    //this method is generated to make admin able to consult all the tickets in database
    @GetMapping("/allTickets")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }
    @GetMapping("/nbrTickets/{date}")
    public Integer getNumberickets(@PathVariable String date){
        String dateString = date;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ticketService.getTicketByDate(date1)
                .size();
    }
    //this method is generated to make a student able to consult all ticket that he already owns in database
    @GetMapping("/getByUsername/{username}")
    public List<Ticket> findTicketByUsername(@PathVariable String username){
        return ticketService.findTicketByUsername(username);
    }
    //this method is generated to make controlleur check if ticket is exist or not
    @GetMapping("/getOne/{id}")
    public Ticket findOneTicket(@PathVariable Integer id){
        return ticketService.findOneTicket(id);
    }

}
