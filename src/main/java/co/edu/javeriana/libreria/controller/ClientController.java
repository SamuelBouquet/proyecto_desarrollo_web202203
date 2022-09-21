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
    public ResponseEntity<?> add(@RequestBody Client aux){
        if(service.saveUser(aux))
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        else{
            return new ResponseEntity<>("El email ya se encuentra\nregistrado",HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> delete(@PathVariable String email, @RequestBody String password){
        if(service.deleteUser(email,password))
            return new ResponseEntity<>("Se ha borrado el usuario\ncon exito",HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>("La contraseña ingresada\nes incorrecta",HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/{email}")
    public void put(@PathVariable String email, @RequestBody Client aux) {
            Client newClient = service.getUserByEmail(email);
            newClient.setName(aux.getName());
            newClient.setPassword(aux.getPassword());
            newClient.setEmail(aux.getEmail());
            service.saveUser(newClient);
    }
}
