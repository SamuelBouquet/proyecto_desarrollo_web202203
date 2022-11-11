package com.example.MicSerivceCliente.service;

import com.example.MicSerivceCliente.domain.Client;
import com.example.MicSerivceCliente.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;


@Service
@Transactional
public class ClientService {

    @Autowired
    ClientRepository repository;

    public Client getUserById(Integer id){ return repository.findById(id).get();}

    public Client getUserByEmail(String email){return repository.findByEmail(email);}

    public Boolean auth(String password, String email){
        try{
            Client aux = repository.findByEmail(email);
            if(aux.getPassword().equals(password)){return true;}
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            return false;
        }
    }

    public boolean saveUser(Client u) {
        try{
            if(repository.findByEmail(u.getEmail())==null) {
                u.setPassword(u.getPassword());
                repository.save(u);
                return true;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteUser(String email, String password){
        Client client = repository.findByEmail(email);
        try {
            if(client.getPassword().equals(password)) {
                client.setActivado(false);
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Client> getAllClients() {
        return repository.findAllActive();
    }
}

