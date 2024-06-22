package com.hafnium.School.exception;

public class SchoolAlreadyExistsException extends RuntimeException{
    public SchoolAlreadyExistsException(String message) {
        super(message);
    }
}
