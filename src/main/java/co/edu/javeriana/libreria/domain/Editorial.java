package co.edu.javeriana.libreria.domain;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
public class Editorial {

    //@Column(name = "id")
    private Integer id;
    //@Column(name = "name")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
