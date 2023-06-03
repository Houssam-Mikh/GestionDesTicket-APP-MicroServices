package com.restau.fsdm.authservice.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {
     public static  final String SECRET="3777217A25432A462D4A614E645266556A586E3272357538782F413F4428472B";

     public boolean validateToken(final String token){
         Jws<Claims> claimsJws= Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
        Date dateExpiration= claimsJws.getBody().getExpiration();
        boolean checkingDate=dateExpiration.after(new Date(System.currentTimeMillis()));
        return checkingDate;
     }

     public String generateToken(String username){
         Map<String ,Object> claims = new HashMap<>();
         return CreateToken(claims,username);
     }
     private String CreateToken(Map<String,Object> claims, String username){
         return Jwts.builder()
                 .setClaims(claims)
                 .setSubject(username)
                 .setIssuedAt(new Date(System.currentTimeMillis()))
                 .setExpiration(new Date((System.currentTimeMillis())+1000*60*30))
                 .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
     }
    private Key getSignKey(){
         byte [] keyBytes= Decoders.BASE64.decode(SECRET);
         return Keys.hmacShaKeyFor(keyBytes);
    }

}
