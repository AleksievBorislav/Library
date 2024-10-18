package com.library.config.exceptions;

public class BorrowingNotFoundException extends RuntimeException {
    public BorrowingNotFoundException(String msg) {
        super(msg);
    }

}
