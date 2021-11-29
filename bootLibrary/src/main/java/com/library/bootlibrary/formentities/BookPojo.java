package com.library.bootlibrary.formentities;

public class BookPojo {
    private String bookName;
    private String authorName;
    private String quantity;

    public BookPojo(){}

    public BookPojo(String bookName, String authorName, String quantity) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.quantity = quantity;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
