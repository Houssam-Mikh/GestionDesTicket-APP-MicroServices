package com.usmba.restau.surveillant.Service;

import com.usmba.restau.surveillant.entities.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SurveillantService {

    @Autowired
    private  RestTemplate restTemplate;

    public TicketResponse checkTicket(Integer id) {
    String ID= Integer.toString(id);
    return restTemplate.getForObject("http://TICKET/tickets/getOne/"+ID+"",TicketResponse.class);

    }

    public void deleteTicket(Integer id) {
        restTemplate.delete("http://TICKET/tickets/delete/"+id);

    }
}
