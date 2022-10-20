package com.example.MicSerivceBook.controller;

import com.example.MicSerivceBook.domain.Book;
import com.example.MicSerivceBook.domain.Editorial;
import com.example.MicSerivceBook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.sql.SQLDataException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/Libro")
public class BookController {

    @Autowired
    BookService bookService;

    @CrossOrigin(origins="https://localhost:4200")
    @GetMapping("")
    public List<Book> list() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable Integer id) {
        try {
            Book book = bookService.getBook(id);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }

    //@GetMapping("/{editorial}")
    //public List<Book> getAllByEditorial(@PathVariable String name){return bookService.getByEditorial(name);}

    @PostMapping("")
    @CrossOrigin(origins="https://localhost:4200")
    public void post(@RequestBody Book book) {
        bookService.saveBook(book);
        //System.out.println(book.getName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Integer id,@RequestBody Book book) {
        try{
            Book newBook = bookService.getBook(id);
            newBook.setId(id);
            newBook.setDescription(book.getDescription());
            newBook.setName(book.getName());
            newBook.setImageUrl(book.getImageUrl());
            newBook.setEditorial(book.getEditorial());
            bookService.saveBook(newBook);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins="https://localhost:4200")
    public void delete(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

    @PostMapping("/Editorial")
    public void addEdit(@RequestBody Editorial edit){bookService.saveEditorial(edit);}

    @GetMapping(path = "/{id}/Editorial")
    public Editorial getEditById(@PathVariable Integer id){
        //System.out.println(id);
        //Integer newId = Integer.getInteger(id);
        return bookService.getEditById(id);
    }

    @PutMapping("/{id}/Editorial")
    public ResponseEntity<?> putEditorial(@PathVariable Integer id, @RequestBody Editorial newEdit){
        try{
            Editorial edit = bookService.getEditById(id);
            edit.setName(newEdit.getName());
            bookService.saveEditorial(edit);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins="https://localhost:4200")
    @GetMapping("/Editorial")
    public List<Editorial> getAllEditorial(){return bookService.getAllEditorial();}

    @CrossOrigin(origins="https://localhost:4200")
    @GetMapping("/{name}/name")
    public Book getBookByName(@PathVariable String name){return bookService.getBookByName(name);}

    @GetMapping("/{name}/Editorial/")
    public Editorial getEditorialByName(@PathVariable String name){return bookService.getEditorialByName(name);}

    public String findAllBooks(Model model){
        List<Book> myBooks = this.bookService.findAllBooks  ();
        for (int i = 0; i < myBooks.size(); i++) {
            System.out.println(myBooks.get(i).getName());
        }
        model.addAttribute("books", myBooks);
        return "welcome";
    }
}

