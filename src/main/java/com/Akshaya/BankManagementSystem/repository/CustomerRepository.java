package com.Akshaya.BankManagementSystem.repository;

import com.Akshaya.BankManagementSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
