package com.intellisoft.library.entity.pojo;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "writer")
public class BookWriter {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",unique=true)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "born")
    private String born;
    @Column(name = "died")
    private String died;
    @Column(name = "website")
    private String website;
    @Column(name = "genre")
    private String genre;
    @OneToMany(mappedBy = "bookWriter",fetch = FetchType.LAZY)
    private List<Book> books;


    public BookWriter() {
    }

    @Override
    public String toString() {
        return this.id+this.name+this.born+this.died+this.website+this.genre;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}