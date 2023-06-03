package com.restau.fsdm.authservice.service;

import com.restau.fsdm.authservice.config.CustomUserDetails;
import com.restau.fsdm.authservice.entity.UserCredential;
import com.restau.fsdm.authservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserCredentialRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredential> cedential= repository.findByUsername(username);
        return cedential.map(CustomUserDetails:: new).orElseThrow(()->new RuntimeException("usernotfoundwithname"));
    }
}
