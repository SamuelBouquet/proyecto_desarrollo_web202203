package co.edu.javeriana.libreria.Repository;

import co.edu.javeriana.libreria.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    @Query(value = "select * from  client u where u.email = ?1 and u.activado = true", nativeQuery = true)
    Client findByEmail(String email);

    @Query(value = "select * from client u where u.activado = true", nativeQuery = true)
    List<Client> findAllActive();
}
