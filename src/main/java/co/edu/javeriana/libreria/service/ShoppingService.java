package co.edu.javeriana.libreria.service;

import co.edu.javeriana.libreria.Repository.ShoppingRepository;
import co.edu.javeriana.libreria.domain.Shopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ShoppingService {

    @Autowired
    ShoppingRepository repository;

    public List<Shopping> findAllByEmail(String email){return repository.findAllByUser(email);}

    public void saveShopping(Shopping s){repository.save(s);}

    public void deleteShopping(Shopping s){repository.delete(s);}
}
