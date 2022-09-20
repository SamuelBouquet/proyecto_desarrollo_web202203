package co.edu.javeriana.libreria.Repository;

import co.edu.javeriana.libreria.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("select '*'   from Book b")
    List<Book> findAllBooksByName();

}
