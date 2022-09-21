package co.edu.javeriana.libreria.domain;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;

    public Editorial() {

    }

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

    public Editorial(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
