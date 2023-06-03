package com.restau.fsdm.authservice.service;

import com.netflix.discovery.converters.Auto;
import com.restau.fsdm.authservice.entity.UserCredential;
import com.restau.fsdm.authservice.repository.UserCredentialRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }
    public boolean ValidateToken(String token){
        return jwtService.validateToken(token);
    }
    public String saveUser(UserCredential user){
        //password should be encrypted
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return "user added successfully";
    }




}
