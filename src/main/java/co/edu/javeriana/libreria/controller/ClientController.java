package co.edu.javeriana.libreria.controller;

import co.edu.javeriana.libreria.domain.Book;
import co.edu.javeriana.libreria.domain.Client;
import co.edu.javeriana.libreria.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/Client")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping("/{email}")
    public ResponseEntity<Client> getUser(@PathVariable String email){
        try {
            Client aux = service.getUserByEmail(email);
            return new ResponseEntity<Client>(aux, HttpStatus.OK);
            //return aux;
        }catch(Exception e){
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
            //return null;
        }
    }


    @GetMapping("")
    public List<Client> getAllClients(){return service.getAllClients();}

    @PostMapping("")
    public void add(@RequestBody Client aux){service.saveUser(aux);}

    @DeleteMapping("/{email}")
    public void delete(@PathVariable String email){service.deleteUser(email);}

    @PutMapping("/{email}")
    public ResponseEntity<?> put(@PathVariable String email, @RequestBody Client aux) {
        try {
            Client newClient = service.getUserByEmail(email);
            newClient.setName(aux.getName());
            newClient.setPassword(aux.getPassword());
            newClient.setEmail(aux.getEmail());
            return new ResponseEntity<>(newClient, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
