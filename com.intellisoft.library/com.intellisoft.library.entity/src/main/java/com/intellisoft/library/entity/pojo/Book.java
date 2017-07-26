package com.intellisoft.library.entity.pojo;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;


    @Entity
    @Table(name="book")

    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id", unique=true)
        private Integer id;

        @Column(name="title")
        private String title;

        @Column(name="pages")
        private Integer pages;

        @Column(name="published")
        private String published;

        @Column(name = "rating")
        private String rating;


        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "writer_id")
        private BookWriter bookWriter;







        public Book() {}




        @Override
        public String toString() {
            return this.id+this.title+this.pages+this.pages+this.published+this.rating;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getPages() {
            return pages;
        }

        public void setPages(Integer pages) {
            this.pages = pages;
        }

        public String getPublished() {
            return published;
        }

        public void setPublished(String published) {
            this.published = published;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public BookWriter getBookWriter() {
            return bookWriter;
        }

        public void setBookWriter(BookWriter bookWriter) {
            this.bookWriter = bookWriter;
        }
    }


