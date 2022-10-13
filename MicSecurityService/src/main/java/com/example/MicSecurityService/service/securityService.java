package com.example.MicSecurityService.service;

import ch.qos.logback.core.net.server.Client;
import com.example.MicSecurityService.repository.securityRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class securityService {

    @Autowired
    securityRepo repository;
    public Client getClient(String user, String pwd) {
        return repository.authByEmail(user,pwd);
    }


}
