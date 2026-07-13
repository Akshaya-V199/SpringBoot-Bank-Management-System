package com.Akshaya.BankManagementSystem.repository;

import com.Akshaya.BankManagementSystem.entity.Customer;
import com.Akshaya.BankManagementSystem.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findByCustomer(Customer customer);

}