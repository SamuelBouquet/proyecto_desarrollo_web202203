package com.example.MicSerivceBook.repository;

import com.example.MicSerivceBook.domain.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EditorialRepository extends JpaRepository<Editorial,Integer> {

    @Query(value = "select * from editorial e where e.name=?1",nativeQuery = true)
    Editorial getByName(String name);
}
