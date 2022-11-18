package com.example.MicSerivceBook.repository;

import com.example.MicSerivceBook.domain.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * clase encargada de la comunicacion entre el microservicio y la tabla editorial de la base de datos
 *  @author Pablo Bright
 *  @author Samuel Lopez
 */
public interface EditorialRepository extends JpaRepository<Editorial,Integer> {


    /**
     * Encontrar instancia de tipo editorial dado un nombre (name)
     * @param name nombre asociado a una instancia de tipo editorial
     * @return instancia tipo editorial
     */
    @Query(value = "select * from editorial e where e.name=?1",nativeQuery = true)
    Editorial getByName(String name);
}
