package com.restau.fsdm.authservice.controller;

import com.restau.fsdm.authservice.entity.UserCredential;
import com.restau.fsdm.authservice.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user){
        return authService.saveUser(user);
    }
    @PostMapping ("/token")
    public String getToken(@RequestBody UserCredential user){

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
        );

        if(authenticate.isAuthenticated()){
            return authService.generateToken(user.getUsername());
        }
        else throw new RuntimeException("invalid access");
    }
    @GetMapping("/validate")
    public String validteToken(@RequestParam String token){
        for(int i=0;i<20;i++){
            System.out.println(token);
        }
        if(authService.ValidateToken(token)){
            return "true";
        }
        else{
            return "false";
        }
    }

}
