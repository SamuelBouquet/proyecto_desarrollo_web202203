package co.edu.javeriana.libreria.controller;


import co.edu.javeriana.libreria.domain.Shopping;
import co.edu.javeriana.libreria.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;


@RestController
@RequestMapping(path = "Shopping")
public class ShoppingController {

    @Autowired
    ShoppingService service;

    @GetMapping("")
    public ResponseEntity<List<Shopping>> getShoppingsByUser(@PathVariable String email){
        try{
            List<Shopping> shops = service.findAllByEmail(email);
            return new ResponseEntity<List<Shopping>>(shops, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<List<Shopping>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{email}")
    public void postShopping(@RequestBody Shopping s){service.saveShopping(s);}


}
