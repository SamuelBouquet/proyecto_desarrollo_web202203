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

/**
 * Clase responsable de la comunicacion entre la base de datos y la clase controller
 *  @author Pablo Bright
 *  @author Samuel Lopez
 */
@Service
@Transactional
public class BookService {


    @Autowired
    BookRepository repository;
    @Autowired
    EditorialRepository EditRepo;
    //============================================

    /**
     * Retorno de lista de todas las instancias de tipo book
     * @return lista de instancias tipo book
     */
    public List<Book> findAllBooks(){return repository.findAll();}

    /**
     * Devolver la instancia tipo book dado un identificador unico (id)
     * @param id identificador numerico unico asociado a una instancia tipo book
     * @return instancia tipo book
     */
    public Book getBook(Integer id){return repository.findById(id).get();}


    /**
     * Devolver una instancia tipo book dado un nombre (name)
     * @param name nombre asociado a la instancia tipo book
     * @return instancia tipo book
     */
    public Book getBookByName(String name){return repository.findBookByName(name);}

    /**
     * Guardar una nueva instancia tipo book en la base de datos
     * @param book instancia tipo book
     */
    public void saveBook(Book book) {repository.save(book);}

    /**
     * borrar una instancia tipo book dado un identificador unico (id)
     * @param id identificador numerico unico asociado a una instancia tipo book
     */
    public void deleteBook(Integer id) {
        repository.delete(repository.findById(id).get());
    }

    /**
     * devolver una instancia tipo page conteniendo instancias tipo book
     * @param pagina instancia tipo pageable conteniendo instancias de tipo book
     * @return instancia tipo page conteniendo instancias tipo book
     */
    public Page<Book> paginado (Pageable pagina){ return repository.findAll(pagina);}

    //=======================================

    /**
     *Guardar instancia tipo editorial (editorial) en la base de datos
     * @param editorial instancia tipo editorial
     */
    public void saveEditorial(Editorial editorial){EditRepo.save(editorial); }

    /**
     * Devolver lista de todas las instancias tipo editorial en la base de datos
     * @return lista de instancias tipo editorial
     */
    public List<Editorial> getAllEditorial(){return EditRepo.findAll();}

    /**
     * Encontrar instancia tipo editorial dado un identificado unico (id)
     * @param id identificador unico numerico
     * @return instancia tipo editorial
     */
    public Editorial getEditById(Integer id){return EditRepo.findById(id).get();}

    /**
     * Devolver instancia tipo editorial dado un nombre(name) asociado a dicha instancia
     * @param name nombre asociado a la instancia tipo editorial
     * @return instancia tipo editorial
     */
    public Editorial getEditorialByName(String name){return EditRepo.getByName(name);}

    //=============================================

}
