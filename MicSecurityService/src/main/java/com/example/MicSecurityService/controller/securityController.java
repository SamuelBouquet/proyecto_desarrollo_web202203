package com.example.MicSecurityService.controller;

import com.example.MicSecurityService.domain.Client;
import com.example.MicSecurityService.service.clientService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping(path = "/login")
public class securityController {

    @Autowired
    public clientService service;

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @PostMapping("/login")
    public String login (@RequestParam("mail") String email, @RequestParam("password")String pwd){
        Client client = service.findByEmail(email, pwd);
        System.out.println("cliente: " + client.getEmail() +" " + client.getPassword());
        if(client != null){
            System.out.println("encontro algo");
            String token = getJWTtoken(email);
            System.out.println(token);
            return token;
        }else{
            System.out.println("encontro nada");
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
                .signWith(SignatureAlgorithm.ES256,
                        key.getBytes()).compact();
        return "Bearer " + token;
    }
}
