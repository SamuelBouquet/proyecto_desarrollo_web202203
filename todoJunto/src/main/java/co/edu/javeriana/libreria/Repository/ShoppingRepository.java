package co.edu.javeriana.libreria.Repository;

import co.edu.javeriana.libreria.domain.Shopping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingRepository extends JpaRepository<Shopping,Integer> {
    @Query(value = "select s.id,s.id_book,s.id_client from shopping s join client c on s.id_client = c.id join book b on b.id=s.id_book where c.email=?1",nativeQuery = true)
    List<Shopping> findAllByUser(String email);

    @Query(value= "select * from shopping s", nativeQuery = true)
    List<Shopping> findShops();
}
