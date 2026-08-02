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

The application follows a layered architecture to maintain separation of concerns and improve code maintainability.

### Controller Layer
Handles incoming HTTP requests and provides REST API endpoints. It communicates with the service layer and returns appropriate responses to the client.

### Service Layer
Contains the core business logic of the application. It processes customer operations, transaction handling, and coordinates communication between the controller and repository layers.

### Repository Layer
Responsible for database operations using Spring Data JPA. It provides methods to perform CRUD operations and interact with the MySQL database.

### Entity Layer
Defines the database entities and represents the structure of tables stored in MySQL. These classes are mapped using JPA annotations.

### Exception Handling Layer
Manages application-specific errors using custom exceptions and global exception handling to provide meaningful error responses.

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
