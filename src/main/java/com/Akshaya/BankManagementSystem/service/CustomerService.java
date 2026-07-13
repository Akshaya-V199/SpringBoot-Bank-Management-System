package com.Akshaya.BankManagementSystem.service;

import com.Akshaya.BankManagementSystem.entity.Customer;
import com.Akshaya.BankManagementSystem.entity.Transaction;
import com.Akshaya.BankManagementSystem.exception.CustomerNotFoundException;
import com.Akshaya.BankManagementSystem.exception.InsufficientBalanceExp;
import com.Akshaya.BankManagementSystem.repository.CustomerRepository;
import com.Akshaya.BankManagementSystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    public Customer saveCustomer(Customer customer){
        customer.setBalance(0.0);
        Customer savedCustomer=customerRepository.save(customer);
        return (savedCustomer);
    }
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();

    }
    public Customer getCustomerById(Long id){
       return customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not found with id: "+id));
    }
    public Customer updateCustomer(Long id,Customer updatedCustomer){
        Customer customer=customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not found with id: "+id));
        customer.setName(customer.getName());
        customer.setEmail(customer.getEmail());
        customer.setPhone(customer.getPhone());

        return customerRepository.save(customer);

    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
    public Customer deposit(Long id,Double amount){
        Customer customer=customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not found with id: "+id));
            customer.setBalance(customer.getBalance()+amount);
            customerRepository.save(customer);

            Transaction transaction=new Transaction();
            transaction.setCustomer(customer);
            transaction.setTransactionType("Deposit");
            transaction.setAmount(amount);
            transaction.setTransactionDate(LocalDateTime.now());
            transactionRepository.save(transaction);
            return customer;

    }
    public Customer withdraw(Long id, Double amount) {
        Customer customer = customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not found with Id: "+id));

        if (customer.getBalance() < amount) {
            throw new InsufficientBalanceExp("Insufficient balance");
        }
                customer.setBalance(customer.getBalance() - amount);
                customerRepository.save(customer);

                Transaction transaction=new Transaction();
                transaction.setCustomer(customer);
                transaction.setTransactionType("Withdraw");
                transaction.setAmount(amount);
                transaction.setTransactionDate(LocalDateTime.now());
                transactionRepository.save(transaction);
                return customer;

            }



    public Double checkBalance(Long id){
        Customer customer=customerRepository.findById(id).orElse(null);
        if(customer!=null){
            return customer.getBalance();
        }
        return null;
    }
    public List<Transaction> getTransactionHistory(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
        return transactionRepository.findByCustomer(customer);
    }


}

