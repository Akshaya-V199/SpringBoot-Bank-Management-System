package com.Akshaya.BankManagementSystem.controller;

import com.Akshaya.BankManagementSystem.entity.Customer;
import com.Akshaya.BankManagementSystem.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/newCustomer")
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer)
    {

        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomers()
    {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(id,customer));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer Deleted Successfully!");
    }
    @PostMapping("/{id}/deposit")
    public ResponseEntity<?>deposit(@PathVariable Long id, @RequestParam Double amount){

        return ResponseEntity.ok(customerService.deposit(id,amount));
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<?>withdraw(@PathVariable Long id, @RequestParam Double amount){

        return ResponseEntity.ok(customerService.withdraw(id,amount));
    }
    @GetMapping("{id}/balance")
    public ResponseEntity<?>checkBalance(@PathVariable Long id){
        Double balance= customerService.checkBalance(id);
        if(balance!=null){
            return ResponseEntity.ok("Current Balance: Rs."+balance);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!");
    }
    @GetMapping("/{id}/transactions")
    public ResponseEntity<?>getTransactionHistory(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getTransactionHistory(id));
    }
    // http://localhost:8080/swagger-ui/index.html


}

