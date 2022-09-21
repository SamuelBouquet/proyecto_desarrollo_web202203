package co.edu.javeriana.libreria.Repository;

import co.edu.javeriana.libreria.domain.Shopping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingRepository extends JpaRepository<Shopping,Integer> {
    @Query("select '*' from Client u join Shopping s on u.id=s.user_id join Book b on b.id=s.book_id where u.email=?1")
    List<Shopping> findAllByUser(String email);
}
