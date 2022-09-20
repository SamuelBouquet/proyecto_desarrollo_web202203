package co.edu.javeriana.libreria.domain;


import javax.persistence.*;

@Entity

public class Book {


    private Integer id;
    private String name;
    private String description;
    private String imageUrl;

    private Integer id_editorial;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(Integer id_editorial) {
        this.id_editorial = id_editorial;
    }
}
