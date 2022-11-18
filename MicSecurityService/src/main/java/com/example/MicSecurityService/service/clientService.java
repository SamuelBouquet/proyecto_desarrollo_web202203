package com.example.MicSecurityService.service;

import com.example.MicSecurityService.domain.Client;
import com.example.MicSecurityService.repository.clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * coneccion entre el controlador y la base de datos con l aresponsabilidad de transformar los datos
 * @author Pablo Bright
 * @author Samuel Suarez
 */
@Service
@Transactional
public class clientService {

    @Autowired
    public clientRepository repository;

    /**
     * Encontrar instancia tipo client mediante busquedas en base a un email (email) y una contraseña (pwd)
     * @param email email asociado a la instancia tipo client
     * @param pwd contraseña asociada a la instancia tipo client
     * @return instancia tipo client
     */
    public Client findByEmail(String email,String pwd){ return repository.findByEmail(email,pwd);}



}
