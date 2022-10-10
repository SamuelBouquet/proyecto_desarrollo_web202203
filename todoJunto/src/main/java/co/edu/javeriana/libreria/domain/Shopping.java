package co.edu.javeriana.libreria.domain;

import javax.persistence.*;

@Entity
public class Shopping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Access(AccessType.FIELD)
    @OneToOne(targetEntity = Book.class , fetch = FetchType.EAGER)
    @JoinColumn(name = "id_book")
    private Book book;

    @Access(AccessType.FIELD)
    @ManyToOne(targetEntity = Client.class , fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client")
    private Client client;

    public Shopping( Book book, Client client) {
        this.book = book;
        this.client = client;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Shopping(){}

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
