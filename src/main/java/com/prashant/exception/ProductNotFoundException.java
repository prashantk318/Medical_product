package com.prashant.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import jdk.jshell.spi.ExecutionControl.RunException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
    
    public ProductNotFoundException(String description) {
        super(description);
    }

}