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

    public void saveBook(Book book) {
        System.out.println("======================");
        System.out.println(book.getName() +" \n"+ book.getId() +" \n"+ book.getImageUrl());

        System.out.println("======================");
        repository.save(book);
    }



    public void deleteBook(Integer id) {
        repository.delete(repository.findById(id).get());
    }

    /*public List<Book> findAllBooks() {
        List<Book> books = new ArrayList();

        Book sicoanalistaBook = new Book();
        sicoanalistaBook.setName("El Siconalista");
        sicoanalistaBook.setDescription("Frederick Starks, psicoanalista de larga experiencia y vida tranquila, recibe una amenaza anónima. Tendrá que emplear toda su astucia para averiguar quién es el autor de esa misiva que promete hacerle la existencia imposible");
        sicoanalistaBook.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/41Zc7DRsnoL._SX327_BO1,204,203,200_.jpg");
        books.add(sicoanalistaBook);

        Book billyBook = new Book();
        billyBook.setName("Billy Summers");
        billyBook.setDescription("Novela sobre un buen tipo con un trabajo muy malo");
        billyBook.setImageUrl("https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1618151020l/56852407.jpg");
        books.add(billyBook);

        Book ilusionistasBook = new Book();
        ilusionistasBook.setName("Los Ilusionistas");
        ilusionistasBook.setDescription("Cuenta la historia de un golpe militar en Chile");
        ilusionistasBook.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/61887EOsA0L.jpg");
        books.add(ilusionistasBook);

        Book soledadBook = new Book();
        soledadBook.setName("Cien Años de Soledad");
        soledadBook.setDescription("El único premio novel de literatura de Colombia");
        soledadBook.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/51g1mv8VEnL._SX322_BO1,204,203,200_.jpg");
        books.add(soledadBook);

        return books;

    }*/

}
