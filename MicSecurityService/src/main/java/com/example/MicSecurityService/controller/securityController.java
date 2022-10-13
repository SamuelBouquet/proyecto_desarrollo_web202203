package com.example.MicSecurityService.controller;

import ch.qos.logback.core.net.server.Client;
import com.example.MicSecurityService.service.securityService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class securityController {
    //@Autowired
    securityService service;
    public securityController() {
        this.service = new securityService();
    }

    @PostMapping(path = "/login")
    public Client login(@RequestParam ("user") String user, @RequestParam ("pwd")String pwd){
        Client client = service.getClient(user,pwd);
        if(service.getClient(user,pwd)== null)
            return null;
        else{
             String token = getJWTToken(user);
             return client;
        }


    }

    private String getJWTToken(String user) {
        String secretKey = "lo que sea";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.
                commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts
                .builder()
                .setId("genericUser")
                .setSubject(user)
                .claim(
                        "authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000000))
                .signWith(SignatureAlgorithm.HS256,secretKey.getBytes()).compact();
        return "Bearer " + token;
    }


}
