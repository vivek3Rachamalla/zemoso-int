package com.library.bootLibrary.hibernateEntities;

import javax.persistence.*;

@Entity
@Table(name = "quantity")
public class Quantity {
    @Id
    @Column(name = "bookId")
    private int bookId;
    @Column(name = "inLibrary")
    private int inLibrary;
    @Column(name = "outLibrary")
    private int outLibrary;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bookId")
    private Book book;

    public Quantity(){}

    public Quantity(int bookId, int inLibrary, int outLibrary) {
        this.bookId = bookId;
        this.inLibrary = inLibrary;
        this.outLibrary = outLibrary;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getInLibrary() {
        return inLibrary;
    }

    public void setInLibrary(int inLibrary) {
        this.inLibrary = inLibrary;
    }

    public int getOutLibrary() {
        return outLibrary;
    }

    public void returnedBook(){
        this.inLibrary++;
        this.outLibrary--;
    }

    public void givingBook(){
        this.inLibrary--;
        this.outLibrary++;
    }

    public void setOutLibrary(int outLibrary) {
        this.outLibrary = outLibrary;
    }
}
