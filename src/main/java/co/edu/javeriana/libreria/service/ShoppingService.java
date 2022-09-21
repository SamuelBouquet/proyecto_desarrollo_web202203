package co.edu.javeriana.libreria.service;

import co.edu.javeriana.libreria.Repository.BookRepository;
import co.edu.javeriana.libreria.Repository.ClientRepository;
import co.edu.javeriana.libreria.Repository.ShoppingRepository;
import co.edu.javeriana.libreria.domain.Book;
import co.edu.javeriana.libreria.domain.Client;
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

    @Autowired
    ClientService clientService ;

    @Autowired
    BookService bookService;

    public List<Shopping> findAllByUser(String email){return repository.findAllByUser(email);}

    public boolean saveShopping(String email,String password, String name){
        try {
            Client c = clientService.getUserByEmail(email);
            if(c!=null && c.getActivado()) {
                System.out.println(c.getName());
                if(c.getPassword().equals(clientService.codify(password))) {
                    Book b = bookService.getBookByName(name);
                    Shopping newS = new Shopping(b,c);
                    repository.save(newS);
                    return true;
                }
            }
        }catch(Exception e){}
        return false;
    }

    public void deleteShopping(Shopping s){repository.delete(s);}

    public List<Shopping> findAllShop(){return repository.findShops();}
}
