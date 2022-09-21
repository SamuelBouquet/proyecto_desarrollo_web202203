package co.edu.javeriana.libreria.controller;


import co.edu.javeriana.libreria.domain.Shopping;
import co.edu.javeriana.libreria.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/Shopping")
public class ShoppingController {

    @Autowired
    ShoppingService service;

    @GetMapping("")
    public List<Shopping> findAllShops(){return service.findAllShop();}

    @GetMapping("/{email}")
    public List<Shopping> getShoppingsByUser(@PathVariable String email){return service.findAllByUser(email);}

    @PostMapping("/{email}/{password}/{name}")
    public ResponseEntity<?> postShopping(@PathVariable String email, @PathVariable String password, @PathVariable String name){
        if(service.saveShopping(email,password,name)){
            return new ResponseEntity<>("se agregó la compra con éxito :)", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("Usuario desactivado, lo sentimos :(", HttpStatus.NOT_ACCEPTABLE);
        }
    }



}
