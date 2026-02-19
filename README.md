# Java Backend Learning Journey

This repository documents my structured learning journey in **Java Backend Development**.  
It brings together my hands-on practice, examples, and mini-projects covering core backend concepts and modern Java frameworks.

The goal of this repository is to:
- Track my backend learning progress in a single place
- Practice concepts with real code
- Showcase my growth from fundamentals to advanced topics

## 📂 Repository Structure
```
java-backend-journey/       # Central repository showcasing my overall backend development journey and learning activities
├── core_java/              # Contains core Java practice code to strengthen fundamental concepts
├── design_patterns/        # Contains implementations of essential design patterns learned in Java
└── task_management_system  # Spring Boot–based application where backend concepts are applied to build a task management system
```

## 📚 Covered Topics - [Core Java](/core_java/)

**Java Basics**  
**•** Syntax **•** Variables **•** Data Types **•** Operators **•** Strings **•** Math **•** Conditions **•** Loops **•** Arrays

**Methods**  
**•** Parameters **•** Overloading **•** Scope **•** Recursion

**Object-Oriented Programming (OOP)**  
**•** Encapsulation **•** Inheritance **•** Polymorphism **•** Abstraction **•** Interfaces **•** Enums **•** Inner Classes **•** Anonymous Classes

**Exceptions & Debugging**  
**•** Try-Catch **•** Multiple Exceptions **•** Try-with-resources

**File Handling & I/O**  
**•** File Read **•** File Write **•** File Delete **•** Streams **•** BufferedReader **•** BufferedWriter

**Collections & Data Structures**  
**•** List **•** Set **•** Map **•** ArrayList **•** LinkedList **•** HashMap **•** TreeMap **•** Iterators **•** Algorithms

**Advanced Java**  
**•** Wrapper Classes **•** Generics **•** Annotations **•** Regex **•** Threads **•** Lambda Expressions

## 📚 Covered Topics - [Design Pattern](design_pattern/)
**•** Singleton **•** Dependency Injection **•** Factory Method **•** Inversion of Control

## 📚 Covered Topics - [Spring Boot](task_management_system/)
**Spring boot** is an extension of the Spring-Framework that simplifies the creation of stand-alone, production-grade Spring-based applications. It provides a fast and efficient way to develop Spring applications with minimal configuration.   
### To work with Spring Boot, it is important to understand the following core principles:
### 1️⃣ Dependency Injection (DI) - [DependencyInjection.java](/design_pattern/DependencyInjection.java)
Dependency Injection (DI) is a design pattern used in object-oriented programming where an object receives its required dependencies from an external source rather than creating them itself. It helps manage how objects are constructed and how they obtain the resources they need. By separating dependency creation from usage, DI improves code flexibility. This results in systems that are easier to modify, test, and maintain.
- Reduces tight coupling between classes
- Improves code reusability and flexibility
- Makes unit testing easier by allowing mock dependencies
- Enhances maintainability and scalability of the system
### 2️⃣ Inversion of Control (IoC) Container - [IocContainer.java](/design_pattern/IocContainer.java)
Inversion of Control Principle (it’s a principle, not a design pattern) is basically about inverting the control flow of a program.  
what does **“Inversion of Control”** even mean?  
`Normally your code controls object creation and flow, With IoC the framework controls object creation and flow`  
👉 The control is inverted
From you → to the container  
That’s it. That’s IoC.

The Spring framework provides an Inversion of Control (IoC) container that manages the creation and lifecycle of objects (beans) and their dependencies.

### Spring provides two main types of IoC containers:  
**BeanFactory:** This is the most basic type of IoC container in Spring. It provides the essential features needed to manage objects (called Beans) in your application. BeanFactory is lightweight and perfect for simple applications where you only need basic dependency injection.

**Application Context:** This is a more advanced type of IoC container that extends the capabilities of BeanFactory. In addition to the basic features, ApplicationContext offers more robust options like event propagation, declarative mechanisms to create a Bean, and a more extensive lifecycle management. It's typically the go-to choice for most Spring applications because of its powerful features.

### 3️⃣ Beans in Spring Boot - [Spring Beans](https://www.linkedin.com/pulse/understanding-beans-spring-boot-nejah-yengui-c6zlf/)
Spring Beans are Java objects managed by the Spring Container, allowing for dependency injection and efficient application configuration.  

**Key Characteristics of Beans:**
- Signleton by Default
- Configurable
- Managed by the Container

**There are three primary ways to define beans in Spring:**
- XML-Based Configuration
- Annotation-Based Configuration
- Java-based Configuration

**Types of Beans in Spring Boot:** Spring provides multiple ways to define Beans, each with its own purpose and use case.  
1️⃣ `@Component` (Most Common)  
This is the most basic way to define a Bean in Spring. It's typically used for generic components.
```bash
@Component
public class MyService {
    public String getServiceName() {
        return "This is MyService";
    }
} 
```
➡ Where to use?
- Utility classes
- General services
- Simple business logic components

2️⃣ `@Service` (Specialized Component for Business Logic)
A specialized version of @Component, used specifically for service classes.
```bash
@Service
public class UserService {
    public String getUser() {
        return "Fetching user details...";
    }
} 
```
➡ Where to use?
- Business logic implementation
- Service layer handling complex operations

3️⃣ `@Repository` (DAO Layer for Data Access)
This is a specialized `@Component` used in the data access layer. It also provides exception translation.
```bash
@Repository
public class UserRepository {
    public List<String> findAllUsers() {
        return List.of("John", "Jane", "Doe");
    }
} 
```
➡ Where to use?
- Database interaction
- DAO (Data Access Object) layer  

4️⃣ `@Controller` (For Handling HTTP Requests)
Used in Spring MVC to handle incoming web requests.
```bash
@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/users")
    public List<String> getUsers() {
        return List.of("Alice", "Bob");
    }
} 
```
➡ Where to use?
- Exposing APIs
- Handling HTTP requests  

5️⃣ `@Bean` (Manual Bean Definition)
Used inside a @Configuration class to define a Bean manually.
```bash
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService();
    }
} 
```
➡ Where to use?
- When you need more control over Bean creation
- Third-party library Beans  

## 4️⃣ Spring Context  
The Spring Context is the core component of the Spring Framework, representing the Spring IoC (Inversion of Control) container. It is responsible for managing the lifecycle of beans, including their creation, configuration, and destruction. The Spring Context acts as a container that holds the beans and provides them to the application whenever required.

**Types of ApplicationContext**  
Spring provides several implementations of the `ApplicationContext`, each suitable for different use cases:

- `ClassPathXmlApplicationContext:` Loads the context definition from an XML file located in the classpath.
- `FileSystemXmlApplicationContext:` Loads the context definition from an XML file in the file system.
- `AnnotationConfigApplicationContext:` Loads the context definition from Java-based configuration classes using annotations.
- `WebApplicationContext:` A specialized version of `ApplicationContext` used in web applications.

**Spring MVC**  
**•** MVC Architecture & Request Flow **•** Controller **•** Restful API **•** Data Binding & Validation **•** Exception Handling **•** Interceptors

**Spring Data JPA**  
**•** JPA Introduction **•** JPA Repository Interface **•** Entity Mapping **•** Fetching Strategies **•** JPQL and Native Queries **•** Paging and Sorting **•** Optimistic & Pessimistic Locking **•** Transactions

**Spring Security Basics**  
**•** Security Basics **•** CSRF **•** XSS **•** SQL Injection **•** Security Filter Chain **•** JWT **•** Signup & Login using JWT **•** Authentication using JWT

## 🧩 Featured Projects  
### 1. Task Management System - [Console Application](/core_java/task_management_system%20console_app/)
- A console-based Java application for Simple Task Management System
- Focuses on OOP concepts, core Java APIs, and real-world problem-solving

### 2. Task Management System - [Spring Boot Application](/task_management_system/) 
- Spring Boot application with CRUD operations, authentication, authorization, and JWT-based security for multi-user access.
- It supports multi-user access using JWT-based security and follows clean, scalable backend design practices.
