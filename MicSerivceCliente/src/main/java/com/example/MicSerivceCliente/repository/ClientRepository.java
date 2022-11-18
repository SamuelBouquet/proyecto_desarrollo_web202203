package com.example.MicSerivceCliente.repository;

import com.example.MicSerivceCliente.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    /**
     * Query encargada de buscar un cliente dado un email
     * @param email email del cliente a buscar
     * @return instancia de cliente por email
     */
    @Query(value = "select * from client c where c.email = ?1", nativeQuery = true)
    Client findByEmail(String email);


    /**
     * Qeruy encargada de retornar todos los clientes que se encuentren activados
     * @return lista total de clientes activados
     */
    @Query(value="select * from client c where c.activado = true", nativeQuery = true)
    List<Client> findAllActive();
}
