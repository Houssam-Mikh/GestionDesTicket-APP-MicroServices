package com.usmba.restau.surveillant.Controllers;

import com.usmba.restau.surveillant.Service.SurveillantService;
import com.usmba.restau.surveillant.entities.TicketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequiredArgsConstructor
@RequestMapping("/surveillants")
public class SurveillantController {

    private final SurveillantService surveillantService;
    // surveillant est un controlleur qui peut gerer l'accés au restaurant donc il peut verifier si un
    //ticket deja existe en utilisant son id , et si oui!  detruire le ticket au cas de consomation
    @GetMapping("/checkTicket/{id}")
    public TicketResponse checkTicket(@PathVariable(name = "id") Integer id){
        return surveillantService.checkTicket(id);
    }
    @GetMapping("deleteTicket/{id}")
    public int deleteTicket(@PathVariable Integer id){
        // TODO: il faut verifier la requettes  
        surveillantService.deleteTicket(id);
        return 1;
    }

}
