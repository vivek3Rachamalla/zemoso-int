package com.library.bootlibrary.customexception;

public class OutOfBook extends RuntimeException {

    public OutOfBook(String message){
        super(message);
    }

}
