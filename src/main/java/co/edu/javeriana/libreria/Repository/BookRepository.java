package co.edu.javeriana.libreria.Repository;

import co.edu.javeriana.libreria.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(value = "select * from book b where b.name=?1", nativeQuery = true)
    Book findBookByName(String name);


    //@Query(value = "select * from book b join editorial e on b.editorial_id=e.id where e.name = ?1",nativeQuery = true)
    //List<Book> getByEditorial(String name);
}
