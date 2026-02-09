# Task Management System

## 🎯 Project Objective
The **Task Management System** is a Spring Boot project designed to help you learn and implement **backend development best practices** using **Clean Architecture** principles.

This project helps you:

- Design and implement **RESTful APIs**
- Perform **CRUD operations** using Spring Data JPA
- Use **DTOs** to separate API contracts from database entities
- Enforce **input validation** with Jakarta Validation
- Handle **enum-based business rules** (Task Status)
- Implement **centralized exception handling** with structured error responses
- Improve **code maintainability, readability, and scalability**
- Gain **hands-on experience** with real-world backend architecture

The project is **beginner-friendly** while following **production-level design patterns**.

## 📂 Project Structure
```
task_management_system  
├───.mvn  
│   └───wrapper  
├───src  
│   ├───main  
│   │   ├───java  
│   │   │   └───com  
│   │   │       └───example  
│   │   │           └───task_management_system  
│   │   │               ├───advices                 # Global exception handling and controller advice classes. 
│   │   │               ├───config                  # Application and framework configuration classes.
│   │   │               ├───controllers             # REST controllers that handle incoming HTTP requests.
│   │   │               ├───dto                     # Data Transfer Objects for request and response payloads.
│   │   │               ├───entities                # JPA entity classes representing database tables.
│   │   │               ├───enums                   # Enumerations used for fixed sets of constants and states.
│   │   │               ├───exceptions              # Custom exception classes for application-specific errors.
│   │   │               ├───repositories            # Data access layer interfaces using Spring Data JPA.
│   │   │               ├───security                # Authentication, authorization, and security configuration.
│   │   │               └───services                # Business logic and service-layer implementations.
│   │   └───resources  
│   └───test  
│       └───java  
│           └───com  
│               └───example  
│                   └───task_management_system  
└───README.md  
```

## 🛠 Prerequisites

To run this project, you need:

- Java (JDK 17 or later)
- Maven
- PostgreSQL
- Any IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Basic Knowledge Required

- Java
- Spring Boot
- REST API
- JPA / Hibernate

Make sure PostgreSQL is running and database credentials are set correctly in `application.properties`.

## ▶ How to Run 
   ```bash
   git clone https://github.com/mdarafat1819/backend-development-with-java.git
   cd backend-development-with-java/task_management_system
   mvn spring-boot:run
   visit: http://localhost:8080/swagger-ui/index.html
```

## 📌 Activities 
### User Management
- A user can create an account using a valid email address.
- The user must verify the email address via OTP.

### Task Management
After creating an account, a user can perform several activities, including:
- Create a task
- View all tasks, including tasks created by other users
- Update their own tasks
- Delete their own tasks

An admin user can perform all operations on both their own tasks and other users’ tasks.

## API Endpoints 
**🔐 Auth Controller**  
Base URL: `http://localhost:8080/api/`
| Method | Endpoint                | Description         |
|--------|-------------------------|---------------------|
| POST   | /auth/register          | Register a new user |
| POST   | /auth/verify-user-email | Verify user email   |
| POST   | auth/login              | Login user          |

**📌 Task Controller**  
Base URL: `http://localhost:8080/api/`
| Method | Endpoint       | Description      |
|--------|----------------|------------------|
| GET    | /tasks         | Get all tasks    |
| GET    | /tasks/{id}    | Get task by ID   |
| POST   | /tasks         | Create a new task|
| PUT    | /tasks/{id}    | Update a task    |
| DELETE | /tasks/{id}    | Delete a task    |