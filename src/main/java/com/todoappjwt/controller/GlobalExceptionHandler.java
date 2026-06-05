package com.todoappjwt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.todoappjwt.Exceptions.TodoNotFoundException;
import com.todoappjwt.entity.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<?> handleTodoNotFoundException(TodoNotFoundException ex) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),"from GlobalExceptionHanndler" );
		// ErrorResponse error = new  ErrorResponse(LocalDateTime.now(),ex.getMessage(), "from todoController's below @ExceptionHandller");
        // return ResponseEntity.status(HttpStatus.NOT_FOUND)
        //         .body(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<?> handleTodoNotFoundException(ArrayIndexOutOfBoundsException ex) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),"from GlobalExceptionHanndler - Maximum size reached." );
		// ErrorResponse error = new  ErrorResponse(LocalDateTime.now(),ex.getMessage(), "from todoController's below @ExceptionHandller");
        // return ResponseEntity.status(HttpStatus.NOT_FOUND)
        //         .body(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
