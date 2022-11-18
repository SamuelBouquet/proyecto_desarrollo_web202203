package com.example.MicSecurityService.domain;

/**
 *  Abstraccion del objeto token de verificacion de registro
 *  @author Pablo Bright
 *  @author Samuel Lopez
 */
public class Token {


    /**
     * cadena de texto hasheada con un algoritmo HS512
     */
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
