package co.edu.javeriana.libreria.service;

import co.edu.javeriana.libreria.Repository.BookRepository;
import co.edu.javeriana.libreria.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookService {


    @Autowired
    BookRepository repository;
    public List<Book> findAllBooks(){return repository.findAll();}

    public Book getBook(Integer id){return repository.findById(id).get();}

    public Book getBookByName(String name){return repository.findBookByName(name);}

    public void saveBook(Book book) {repository.save(book);}

    public void deleteBook(Integer id) {
        repository.delete(repository.findById(id).get());
    }

    //public List<Book> getByEditorial(String name){
    //    return repository.getByEditorial(name);
    //};
}
