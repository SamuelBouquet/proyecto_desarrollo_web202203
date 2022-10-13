package repository;

import Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientAuth extends JpaRepository<Integer, Client> {

    @Query(value="select * from client c where c.email",nativeQuery = true)
    Client authIfExist(String email, String pwd);
}
