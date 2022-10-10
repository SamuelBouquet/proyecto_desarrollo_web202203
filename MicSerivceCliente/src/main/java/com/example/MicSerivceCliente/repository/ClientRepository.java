package com.example.MicSerivceCliente.repository;

import com.example.MicSerivceCliente.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    @Query(value="select * from client c where c.email = ?1",nativeQuery = true)
    Client findByEmail(String email);

    @Query(value="select * from client c where c.activado = true", nativeQuery = true)
    List<Client> findAllActive();
}
