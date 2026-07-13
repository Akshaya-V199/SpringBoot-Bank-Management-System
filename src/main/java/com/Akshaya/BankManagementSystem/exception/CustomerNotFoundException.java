package com.Akshaya.BankManagementSystem.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String msg){
        super(msg);
    }
}
