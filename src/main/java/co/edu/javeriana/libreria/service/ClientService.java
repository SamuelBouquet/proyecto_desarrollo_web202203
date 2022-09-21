package co.edu.javeriana.libreria.service;

import co.edu.javeriana.libreria.Repository.ClientRepository;
import co.edu.javeriana.libreria.domain.Book;
import co.edu.javeriana.libreria.domain.Client;
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
            if(codify(aux.getPassword()).equals(codify(password))){return true;}
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            return false;
        }
    }

    public void saveUser(Client u) {
        try{
            u.setPassword(codify(u.getPassword()));
            repository.save(u);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void deleteUser(String email){repository.delete(repository.findByEmail(email));}


    public String codify(String text) throws Exception{
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(text.getBytes());
        byte[] codify = m.digest();
        BigInteger bigInt = new BigInteger(1,codify);
        String hashtext = bigInt.toString(16);
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
        return hashtext;
    }

    public List<Client> getAllClients() {
        return repository.findAll();
    }
}
