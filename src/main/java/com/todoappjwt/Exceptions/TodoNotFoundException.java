package com.todoappjwt.Exceptions;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(String message){
        super(message);
    }
    
}