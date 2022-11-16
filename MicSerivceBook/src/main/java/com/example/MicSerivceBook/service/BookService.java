package com.example.MicSerivceBook.service;

import com.example.MicSerivceBook.domain.Book;

import com.example.MicSerivceBook.domain.Editorial;
import com.example.MicSerivceBook.repository.BookRepository;
import com.example.MicSerivceBook.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {


    @Autowired
    BookRepository repository;
    @Autowired
    EditorialRepository EditRepo;
    //============================================

    public List<Book> findAllBooks(){return repository.findAll();}
    public Book getBook(Integer id){return repository.findById(id).get();}
    public Book getBookByName(String name){return repository.findBookByName(name);}
    public void saveBook(Book book) {repository.save(book);}
    public void deleteBook(Integer id) {
        repository.delete(repository.findById(id).get());
    }

    public Page<Book> paginado (Pageable pagina){ return repository.findAll(pagina);}
    //=======================================

    public void saveEditorial(Editorial editorial){EditRepo.save(editorial); }
    public List<Editorial> getAllEditorial(){return EditRepo.findAll();}
    public Editorial getEditById(Integer id){return EditRepo.findById(id).get();}
    public Editorial getEditorialByName(String name){return EditRepo.getByName(name);}

    //=============================================

}
