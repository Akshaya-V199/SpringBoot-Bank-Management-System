# Bank Management System

A backend banking application developed using Java, Spring Boot, and MySQL to manage customer accounts and banking transactions through RESTful APIs. The application follows a layered architecture using Controller, Service, Repository, and Entity components.

## Overview

The Bank Management System provides functionalities for managing customer information and performing banking operations such as deposits, withdrawals, and fund transfers. It is designed with a focus on clean architecture, database integration, and proper exception handling.

## Features

### Customer Management
- Create customer accounts
- Retrieve customer details
- Update customer information
- Delete customer accounts
- View customer records

### Transaction Management
- Deposit money into accounts
- Withdraw money from accounts
- Transfer funds between accounts
- Maintain transaction records
- Validate account balance during transactions

### Exception Handling
- Implemented custom exceptions
- Centralized exception handling using global exception handler
- Proper API error responses

## Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Backend programming language |
| Spring Boot | Application development framework |
| Spring Data JPA | Database interaction |
| Hibernate | Object Relational Mapping |
| MySQL | Database management system |
| Maven | Dependency management |
| REST API | Client-server communication |

## Project Architecture

├── controller
│ └── Handles API requests and responses
│
├── service
│ └── Contains business logic
│
├── repository
│ └── Handles database operations
│
├── entity
│ └── Defines database entities
│
└── exception
└── Manages application exceptions


## Database Configuration

This project uses MySQL for storing customer and transaction data.

Database configuration is provided in:

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bankdb
spring.datasource.username=root
spring.datasource.password=your_password
```
Steps to Run
1. Clone the repository-> git clone <repository-url>
2. Create the database in MySQL-> CREATE DATABASE bankdb;
3. Configure database credentials in application.properties
4. Run the application->mvn spring-boot:run
