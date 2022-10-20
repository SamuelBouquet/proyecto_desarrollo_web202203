package com.example.MicSecurityService.service;

import com.example.MicSecurityService.domain.Client;
import com.example.MicSecurityService.repository.clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class clientService {

    @Autowired
    public clientRepository repository;

    public Client findByEmail(String email,String pwd){ return repository.findByEmail(email,pwd);}



}
