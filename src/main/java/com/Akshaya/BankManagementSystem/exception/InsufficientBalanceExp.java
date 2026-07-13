package com.Akshaya.BankManagementSystem.exception;

public class InsufficientBalanceExp extends RuntimeException{

    public InsufficientBalanceExp(String msg){
        super(msg);
    }
}
