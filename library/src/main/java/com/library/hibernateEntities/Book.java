package com.library.hibernateEntities;


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
    @Column(name = "available")
    private int available;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bookId",
                 cascade = {CascadeType.DETACH,CascadeType.MERGE,
                         CascadeType.PERSIST,CascadeType.REFRESH})
    public List<Record> recordList;

    public Book(){}

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

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }
}
