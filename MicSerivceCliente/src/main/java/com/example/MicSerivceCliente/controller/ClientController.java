package com.example.MicSerivceCliente.controller;

import com.example.MicSerivceCliente.domain.Client;
import com.example.MicSerivceCliente.service.ClientService;
import org.hibernate.secure.spi.GrantedPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * clase encargada de la la la recepecion de mensajes referentes a los cliente mediante metodos http
 *
 * metodos HTTP soportados
 *      -GET
 *      -POST
 *      -PUT
 *      -DELETE
 * ruta de servicio: localhost:8082/Client
 * @author Pablo Bright
 * @author Samuel Lopez
 */
@RestController
@RequestMapping(path = "/Client")
public class  ClientController {
    @Autowired
    ClientService service;


    /**
     * Recuperar la lista de clientes activos total de la base de datos
     * @return Lista de clientes mediante metodo http GET
     */
    @CrossOrigin("https://localhost:4200")
    @GetMapping("/all")
    public List<Client> getAll(){

        return service.getAllClients();
    }

    /**
     * hallar instancia al al epertenezca el email
     * @param email email del cliente
     * @return instancia de cliente retornado
     */
    @GetMapping("/{email}")
    public ResponseEntity<Client> getUser(@PathVariable String email){
        try {
            Client aux = service.getUserByEmail(email);
            return new ResponseEntity<Client>(aux, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     *registrar un nuevo cliente con un email, pwd y nombre respectivamente
     * @param email email del nuevo cliente
     * @param pwd contraseña del nuevo cliente
     * @param name nombre del nuevo cliente
     */
    @PostMapping("")
    public void register(@RequestParam("mail") String email, @RequestParam("password") String pwd ,@RequestParam("name") String name){
        System.out.println(email +" "+  pwd +" "+ name);
        Client newClient = new Client(email,pwd,name);
        service.saveUser(newClient);
    }

    /**
     *se desactiva un cliente dado un email y una contraseña
     * @param email email del cliente
     * @param password contraseña del cliente
     * @return mensaje de verificacion de la operacion (ACCPETED or UNAUTHORIZED)
     */
    @DeleteMapping("/{email}")
    public ResponseEntity<?> delete(@PathVariable String email, @RequestBody String password){
        if(service.deleteUser(email,password))
            return new ResponseEntity<>("Se ha borrado el usuario\ncon exito",HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>("La contraseña ingresada\nes incorrecta",HttpStatus.UNAUTHORIZED);
    }

    /**
     * actualizar el cliente al que le pertenezca el email, usando los datos de la instancia aux
     * @param email emial del cliente
     * @param aux instancia de cliente actualizada
     */
    @PutMapping("/{email}")
    public void put(@PathVariable String email, @RequestBody Client aux) {
        Client newClient = service.getUserByEmail(email);
        newClient.setName(aux.getName());
        newClient.setPassword(aux.getPassword());
        newClient.setEmail(aux.getEmail());
        service.saveUser(newClient);
    }


}
