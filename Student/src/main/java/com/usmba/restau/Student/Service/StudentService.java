package com.usmba.restau.Student.Service;
import com.usmba.restau.Student.entites.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    private  final RestTemplate restTemplate;


    public TicketDTO createTicket(TicketRequest request, String username) {
        TicketDTO ticket=new TicketDTO(request.getTypeRepas(),request.getDateConsomation(),username);
        return restTemplate.postForObject("http://TICKET/tickets/create",ticket,TicketDTO.class);

    }
    public List<TicketResponse> getTickets(String username){
        //String username=session[username]
        String url="http://TICKET/tickets/getByUsername/"+username;
        List<TicketResponse> ticketResponseList=restTemplate.getForObject(url,List.class);
        return ticketResponseList;
    }
    public TicketResponse getTicket(Integer id ){

        String ID=Integer.toString(id);
        return restTemplate.getForObject("http://TICKET/tickets/getOne/"+ID+"",TicketResponse.class);
    }
    public void deleteTicket(Integer id) {
        restTemplate.delete("http://TICKET/tickets/delete/"+id+"");
    }
}
