package com.usmba.restau.Student.controller;

import com.usmba.restau.Student.Service.StudentService;
import com.usmba.restau.Student.entites.TicketRequest;
import com.usmba.restau.Student.entites.TicketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
@EnableDiscoveryClient
public class StudentController {
    private final StudentService studentService;
    @PostMapping("/createTicket")
    public void createTicket(@RequestBody TicketRequest request){
        // TODO: username <== on doit le recuperer par Session " conected User From APIGateway" !!!!
        String username="s139389047";
        studentService.createTicket(request,username);
    }
    @GetMapping("/getMyTickets/{username}")
    public List<TicketResponse> getTickets(@PathVariable("username") String username){
        return studentService.getTickets(username);
    }
    @GetMapping("getTicket/{id}")
    public TicketResponse getOneTicket(@PathVariable Integer id){
        return studentService.getTicket(id);
    }
    @GetMapping("/deleteTicket/{id}")
    public void deleteTicket(@PathVariable Integer id){
        studentService.deleteTicket(id);

    }
}
