package com.example.MicSecurityService.repository;

import com.example.MicSecurityService.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface clientRepository extends JpaRepository<Client,Integer> {

    /**
     * Realizar una query a la tabla client de la base de datos dado un email y una constraseña
     * @param email email asociado a la instancia de cliente
     * @param pwd contraseña asociada a la instancia cliente
     * @return instancia cliente
     */
    @Query(value = "select * from client c where c.email = ?1 and c.password = ?2",nativeQuery = true)
    Client findByEmail(String email, String pwd);


}
