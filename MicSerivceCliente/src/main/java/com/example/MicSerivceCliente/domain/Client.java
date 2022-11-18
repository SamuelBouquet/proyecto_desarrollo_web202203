package com.example.MicSerivceCliente.domain;

import javax.persistence.*;


/**
 * entindad encargada de la instanciacion de los clientes
 * @author Pablo Bright
 * @author Samuel Lopez
 */
@Entity
public class Client {


    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "activado")
    private Boolean activado;

    /**
     * @param email email del cliente a crear
     * @param password contraseña del cliente a crear
     * @param name nombre del cliente a crear
     */
    public Client(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.activado = true;
    }
    public Client(){

    }

    public Boolean getActivado() {
        return activado;
    }

    public void setActivado(Boolean activado) {
        this.activado = activado;
    }

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

