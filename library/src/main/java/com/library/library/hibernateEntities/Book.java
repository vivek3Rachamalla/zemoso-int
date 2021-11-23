package com.library.hibernateEntities;


import com.library.pojo.bookPojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bookId")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name="author")
    private String author;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bookId",
                 cascade = {CascadeType.DETACH,CascadeType.MERGE,
                         CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Record> recordList;
    @OneToOne()
    @PrimaryKeyJoinColumn
    private  Quantity quantity;
    public Book(){}

    public Book(bookPojo bookPojo){
        this.name=bookPojo.getBookName();
        this.author=bookPojo.getAuthorName();
        this.quantity=new Quantity(id,Integer.parseInt(bookPojo.getQuantity()),0);
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }
}

