package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ISBN;
    private String title;
    private String author;
    private Double price;


    public Book(Long id, String ISBN, String title, String Author, Double Price) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.author = Author;
        this.price = Price;

    }
}
