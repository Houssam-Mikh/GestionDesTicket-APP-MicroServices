package com.usmba.restau.admin.controller;

import com.netflix.discovery.converters.Auto;
import com.usmba.restau.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RequiredArgsConstructor
@RestController
@RequestMapping("/admins")
@EnableDiscoveryClient
public class AdminController {
    private final AdminService adminService;
    @GetMapping("/nbrTicket/{date}")
    public Integer getNumberOfTickets(@PathVariable("date")String date){
        return adminService.getNumberOfTickets(date);
    }
    // TODO: definir 4 méthode
    //1 et 2 : create student and remove student
    //3 et 4 : create surveillant and remove surveillant

}
