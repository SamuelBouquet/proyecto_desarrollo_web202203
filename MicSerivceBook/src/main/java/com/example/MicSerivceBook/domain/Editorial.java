package com.example.MicSerivceBook.domain;

import javax.persistence.*;

/**
 * Abstraccion de un objeto tipo editorial con intancias en la base de datos
 *  @author Pablo Bright
 *  @author Samuel Lopez
 */
@Entity
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}