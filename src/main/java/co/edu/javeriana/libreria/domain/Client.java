package co.edu.javeriana.libreria.domain;

import co.edu.javeriana.libreria.service.ClientService;

import javax.persistence.*;

@Entity
public class Client {

    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {this.password = password;}

    public String getName() {
        return name;
    }
    public void setName(String nombre) {
        this.name = nombre;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
