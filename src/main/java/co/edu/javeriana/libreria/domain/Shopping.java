package co.edu.javeriana.libreria.domain;

import javax.persistence.*;

@Entity
public class Shopping {

    private Integer id;
    private Integer user_id;
    private Integer book_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Shopping(Integer id, Integer user_id, Integer book_id) {
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
    }

    public Shopping(){}

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }
}
