package com.example.MicSecurityService.repository;

import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface securityRepo extends JpaRepository<Integer, Client> {

    @Query(value = "select * from client c where c.email = ?1,c.pwd = ?2",nativeQuery = true)
    Client authByEmail(String email, String pwd);
}
