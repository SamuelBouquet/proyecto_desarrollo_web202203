package com.example.MicSerivceBook.controller;

import com.example.MicSerivceBook.domain.Book;
import com.example.MicSerivceBook.domain.Editorial;
import com.example.MicSerivceBook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //      ya se supone que funciona esto...
    @CrossOrigin(origins = "https://localhost:4200")
    @GetMapping("/paginados")
    public ResponseEntity<Page<Book>> paginacion(
           @RequestParam(name = "pag") Integer pagina,
           @RequestParam(defaultValue = "id",name="order") String order,
           @RequestParam(defaultValue = "true", name="asc") boolean asc){

        Page<Book> rturned = bookService.paginado(PageRequest.of(pagina,10, Sort.by(order)));
        if(!asc){
            rturned = bookService.paginado(PageRequest.of(pagina,10, Sort.by(order).descending()));
        }
        return new ResponseEntity<Page<Book>>(rturned,HttpStatus.OK);

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
//    @CrossOrigin(origins="https://localhost:4200")
    public void post(@RequestBody Book book) {
        System.out.println(book.getName());
        bookService.saveBook(book);

    }


    @PutMapping("{id}")

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

}

