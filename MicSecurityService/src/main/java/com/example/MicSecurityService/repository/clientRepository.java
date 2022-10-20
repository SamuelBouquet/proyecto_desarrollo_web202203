package com.example.MicSecurityService.repository;

import com.example.MicSecurityService.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface clientRepository extends JpaRepository<Client,Integer> {

    @Query(value = "select * from client c where c.email = ?1 and c.password = ?2",nativeQuery = true)
    Client findByEmail(String email, String pwd);


}
