package com.library.bootLibrary.customException;

public class OutOfBook extends RuntimeException {

    public OutOfBook(String message){
        super(message);
    }

}
