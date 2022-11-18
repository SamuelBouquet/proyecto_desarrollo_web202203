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


/**
 * @author Pablo Bright
 * @author Samuel Lopez
 */
@RestController
@RequestMapping(path = "/Libro")
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * retornar en una lista todos las instancias de books en la base de datos
     * @return lista de intancias de books
     */
    @CrossOrigin(origins="https://localhost:4200")
    @GetMapping("")
    public List<Book> list() {
        return bookService.findAllBooks();
    }

    /**
     * encarado de retornar una instancia de pagina con books dado un numero de pagina, un orden (ascendente o descendente) y un tipo de organizacion (siendo por nombre,
     * por id, etc...)
     * @param pagina numero de la pagina a retornar
     * @param order parametro que definiria el orden la pagina
     * @param asc paametro encargado de definir el tipo de orden (ascendente o descendente)
     * @return instancia de pagina organizada por parametros
     */
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

    /**
     * buscar una instancia de book dado un id en la base de datos
     * @param id idenificiador numerico de la instancia book a retornar
     * @return instancia de book correspondiente al id proporcionado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable Integer id) {
        try {
            Book book = bookService.getBook(id);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * ingresar una instancia de book en la base de datos
     * @param book instancia tipo book que se ingresara
     */
    @PostMapping("")
//    @CrossOrigin(origins="https://localhost:4200")
    public void post(@RequestBody Book book) {
        System.out.println(book.getName());
        bookService.saveBook(book);

    }

    /**
     * actualizar una instancia de book dado un identificador unico (id) usando la nueva instancia que lo actualizara (book)
     * @param id identificador unico del libro a actualizar
     * @param book nueva instancia tipo book con los datos actualizados que se ingresara
     * @return codigo http para definir el exito de la operacion (OK, NOT_FOUND)
     */
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

    /**
     * borrar la instancia tipo book de la base de datos al que corresponda el identificador (id)
     * @param id identificador unico de la instancia tipo book
     */
    @DeleteMapping("/{id}")
    @CrossOrigin(origins="https://localhost:4200")
    public void delete(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

    /**
     * añadir una nueva instancia editorial (edit) a la base de datos
     * @param edit nueva instancia editorial
     */
    @PostMapping("/Editorial")
    public void addEdit(@RequestBody Editorial edit){bookService.saveEditorial(edit);}


    /**
     * retornar la instancia editorial dado un identificador unico (id) de la editorial
     * @param id identificador unico de la editorial a buscar
     * @return instancia de la editorial encontrada o null en caso de no existir editorial asociada al id
     */
    @GetMapping(path = "/{id}/Editorial")
    public Editorial getEditById(@PathVariable Integer id){
        return bookService.getEditById(id);
    }

    /**
     * actualizar una instancia de la editorial en la base de datos dado el identificador unico de la editorial
     * @param id identificador de la instancia editorial a actualizar
     * @param newEdit nuea instancia editorial que actualizara los datos de la instancia avctual de la editorial
     * @return codigo http correspondiente al exito de la operacion (OK, NOT_FOUND)
     */
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


    /**
     * retornar la una lista de instancias de editoriales
     * @return lista de editoriales
     */
    @CrossOrigin(origins="https://localhost:4200")
    @GetMapping("/Editorial")
    public List<Editorial> getAllEditorial(){return bookService.getAllEditorial();}

    /**
     * retorno de instancia book dado un nombre (name) unico
     * @param name nombre de la instancia tipo book a retornara
     * @return instancia tipo book
     */
    @CrossOrigin(origins="https://localhost:4200")
    @GetMapping("/{name}/name")
    public Book getBookByName(@PathVariable String name){return bookService.getBookByName(name);}

    /**
     * retornar instancia tipo editorial dado un nombre(name) asociado al objeto
     * @param name nombre asociado a la instancia tipo editorial
     * @return instancia editorial
     */
    @GetMapping("/{name}/Editorial/")
    public Editorial getEditorialByName(@PathVariable String name){return bookService.getEditorialByName(name);}

}

