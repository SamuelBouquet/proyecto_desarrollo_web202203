package com.example.MicSecurityService.controller;

import com.example.MicSecurityService.domain.Client;
import com.example.MicSecurityService.domain.Token;
import com.example.MicSecurityService.service.clientService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping(path = "/login")
public class securityController {

    @Autowired
    public clientService service;


    @PostMapping("/login")
    public Token login (@RequestParam("mail") String email, @RequestParam("password")String pwd){
        Client client = service.findByEmail(email, pwd);
        if(client != null){
            Token token = new Token();
            token.setToken(getJWTtoken(email));
            return token;
        }else{
            return null;
        }
    }

    private String getJWTtoken(String email) {
        String key = "lo que sea";
        List<GrantedAuthority> grantedAthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("Admin")
                .setSubject(email)
                .claim("authorities",
                        grantedAthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 10000))
                .signWith(SignatureAlgorithm.HS512,
                        key.getBytes()).compact();
        return "Bearer " + token;
    }
}
