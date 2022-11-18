package com.example.MicSerivceCliente.service;

import com.example.MicSerivceCliente.domain.Client;
import com.example.MicSerivceCliente.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;


/**
 * @author Pablo Bright
 * @author Samuel Lopez
 */
@Service
@Transactional
public class ClientService {

    @Autowired
    ClientRepository repository;

    /**
     * encintrar cliente por un id dado
     * @param id de cliente a buscar
     * @return instancia del cliente encontrado
     */
    public Client getUserById(Integer id){ return repository.findById(id).get();}

    /**
     * instancia de un cliente dado un email si existe, de lo contrario retorna null
     * encontrar cliente dado un email
     * @param email emial de un de cliente
     * @return instancia de cliente o null
     */
    public Client getUserByEmail(String email){return repository.findByEmail(email);}

    /**
     * metodo para guardar una nueva instancia de cliente dado un cliente pasado por parametro
     * @param u instancia de cliente nueva a guardar
     * @return booelano siendo true si se pudo efectuar el guardado y false si hubo un error al hacerlo
     */
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

    /**
     * borrar una instancia de cliente de la base de datos
     * @param email email del cliente a borrar
     * @param password contraseña del cliente a borrar
     * @return booleano que indica si se realizo el borrado exitosamente, siendo true para el caso positivo y false para el contrario
     *
     */
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

    /**
     * busca todos los clientes activos dentro de la base de datos
     * @return lista de clientes
     */
    public List<Client> getAllClients() {
        return repository.findAllActive();
    }
}

