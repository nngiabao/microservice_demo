package com.example.demo.Exception;

public class CustomerAlreadyExistsException extends RuntimeException {
    //
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
