package com.saran.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="name")
    private String name;

    @ManyToMany(mappedBy = "authors")
    private List<Book> authors = new ArrayList<>();

    public Author() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Book> authors) {
        this.authors = authors;
    }

    public void setName(String name) {
        this.name = name;
    }
}
