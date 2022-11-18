package com.example.MicSerivceBook.repository;


import com.example.MicSerivceBook.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * clase encargada de la comunicacion entre el microservicio y la tabla book de la base de datos
 *  @author Pablo Bright
 *  @author Samuel Lopez
 */
public interface BookRepository extends JpaRepository<Book,Integer> , PagingAndSortingRepository<Book,Integer>, QueryByExampleExecutor<Book> {

    /**
     * encontrar en la base de datos instancia tipo book asociado a un nombre (name)
     * @param name nombre asociado a la instancia tipo book
     * @return instancia tipo book
     */
    @Query(value = "select * from book b where b.name=?1", nativeQuery = true)
    Book findBookByName(String name);

}
