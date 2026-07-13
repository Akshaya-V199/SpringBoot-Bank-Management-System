package com.Akshaya.BankManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?>handleCustomerNotFoundException(CustomerNotFoundException ex)
    {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InsufficientBalanceExp.class)
    public ResponseEntity<?>handleInsufficientBalanceExp(InsufficientBalanceExp ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
