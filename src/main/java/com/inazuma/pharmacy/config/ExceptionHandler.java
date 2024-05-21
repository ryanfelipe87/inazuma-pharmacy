package com.inazuma.pharmacy.config;

import com.inazuma.pharmacy.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    public ResponseEntity<String> handlerNotFoundException(NotFoundException notFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundException.getMessage());
    }
}
