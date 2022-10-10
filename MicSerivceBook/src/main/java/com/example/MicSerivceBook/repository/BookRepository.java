package com.example.MicSerivceBook.repository;


import com.example.MicSerivceBook.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select * from book b where b.name=?1", nativeQuery = true)
    Book findBookByName(String name);
}
