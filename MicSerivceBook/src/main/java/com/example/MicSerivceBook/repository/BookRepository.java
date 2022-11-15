package com.example.MicSerivceBook.repository;


import com.example.MicSerivceBook.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface BookRepository extends JpaRepository<Book,Integer> , PagingAndSortingRepository<Book,Integer>, QueryByExampleExecutor<Book> {
    @Query(value = "select * from book b where b.name=?1", nativeQuery = true)
    Book findBookByName(String name);
}
//gracias pablito jejejje