package bean;

import java.util.ArrayList;

public class BookWriter {
    private int id;
    private String name;
    private String born;
    private String died;
    private String website;
    private String genre;
    private ArrayList<Book> bookList;

    public BookWriter() {}

    public BookWriter(int id, String name, String born, String died, String website, String genre) {
        this.id = id;
        this.name = name;
        this.born = born;
        this.died = died;
        this.website = website;
        this.genre = genre;
    }

    public BookWriter(String name, String born, String died, String website, String genre) {
        this.name = name;
        this.born = born;
        this.died = died;
        this.website = website;
        this.genre = genre;
    }

    public BookWriter(int id, String name, String born, String died, String website, String genre, ArrayList<Book> bookList) {
        this.id = id;
        this.name = name;
        this.born = born;
        this.died = died;
        this.website = website;
        this.genre = genre;
        this.bookList = bookList;
    }

    public BookWriter(String name, ArrayList<Book> bookList) {
        this.name = name;
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }
}
