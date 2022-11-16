package com.example.MicSerivceCliente.controller;

import com.example.MicSerivceCliente.domain.Client;
import com.example.MicSerivceCliente.service.ClientService;
import org.hibernate.secure.spi.GrantedPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Client")
public class       ClientController {
    @Autowired
    ClientService service;

    @CrossOrigin("https://localhost:4200")
    @GetMapping("/all")
    public List<Client> getAll(){

        return service.getAllClients();
    }

    @GetMapping("/{email}")
    public ResponseEntity<Client> getUser(@PathVariable String email){
        try {
            Client aux = service.getUserByEmail(email);
            return new ResponseEntity<Client>(aux, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void register(@RequestParam("mail") String email, @RequestParam("password") String pwd ,@RequestParam("name") String name){
        System.out.println(email +" "+  pwd +" "+ name);
        Client newClient = new Client(email,pwd,name);
        service.saveUser(newClient);
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
