package co.edu.javeriana.libreria.domain;


import javax.persistence.*;

@Entity

public class Book {
    private Integer id;

    private String name;
    private String description;
    private String imageUrl;

//
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

  //  public Editorial getEditorial() {
   //     return editorial;
    //}

    //public void setEditorial(Editorial editorial) {
      //  this.editorial = editorial;
    //}
}
