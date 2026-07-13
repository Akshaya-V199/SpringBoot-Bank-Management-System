package com.Akshaya.BankManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    private String transactionType;
    private double amount;
    private LocalDateTime transactionDate;
}
