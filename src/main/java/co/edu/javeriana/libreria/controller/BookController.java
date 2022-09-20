package co.edu.javeriana.libreria.controller;

import co.edu.javeriana.libreria.domain.Book;
import co.edu.javeriana.libreria.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/Libro")
public class BookController {

    @Autowired
    BookService bookService;

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

    @PostMapping("")
    public void post(@RequestBody Book user) {
        System.out.println(user.getName());
        bookService.saveBook(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Integer id,@RequestBody Book book) {
       try{
           Book newBook = bookService.getBook(id);
           newBook.setId(id);
           newBook.setDescription(book.getDescription());
           newBook.setName(book.getName());
           newBook.setImageUrl(book.getImageUrl());
           bookService.saveBook(newBook);
           return new ResponseEntity<>(HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }



    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }


    public String findAllBooks(Model model){
        List<Book> myBooks = this.bookService.findAllBooks  ();
        for (int i = 0; i < myBooks.size(); i++) {
            System.out.println(myBooks.get(i).getName());
        }
        model.addAttribute("books", myBooks);
        return "welcome";
    }
}
