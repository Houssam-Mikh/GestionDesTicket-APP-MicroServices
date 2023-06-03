package com.usmba.restau.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class AdminService {
    @Autowired
    private  RestTemplate restTemplate;
    public Integer getNumberOfTickets(String date) {
        return restTemplate.getForObject("http://TICKET/tickets/nbrTickets/"+date, Integer.class);
    }
}
