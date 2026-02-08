# Java Design Patterns & Core Concepts

This repository contains my learning and hands-on implementations of **core object-oriented design patterns and principles in Java**.  
The goal of this project is to deeply understand **how modern frameworks like Spring work internally** by implementing these concepts from scratch.

---

## 📌 Topics Covered

### 1️⃣ Singleton Pattern - [Singleton.java](Singleton.java)
Ensures that a class has **only one instance** and provides a global access point to it.

**Key concepts learned:**
- Private constructor
- Static instance
- Lazy initialization
- Object identity (`==`)
- Thread-safety considerations

### 2️⃣ Dependency Injection (DI) - [DependencyInjection.java](DependencyInjection.java)
Dependency Injection removes tight coupling by **injecting dependencies instead of creating them directly**.

**Key concepts learned:**
- Programming to interfaces
- Constructor-based injection (recommended)
- Loose coupling
- Testability and flexibility

### 3️⃣ Factory Method Pattern - [FactoryMethod.java](FactoryMethod.java)

Encapsulates object creation logic and allows the client to request objects **without knowing their concrete classes.**

**Key concepts learned:**
- Centralized object creation
- Open–Closed Principle
- Replacing new with factories
- Runtime object selection

### 4️⃣ Inversion of Control (IoC) Container - [IocContainer.java](IocContainer.java)
what does **“Inversion of Control”** even mean?  
`Normally your code controls object creation and flow, With IoC the framework controls object creation and flow`  
👉 The control is inverted
From you → to the container  
That’s it. That’s IoC.

#### A custom-built IoC container that:
- Creates objects
- Decides which implementation to use
- Injects dependencies
- Controls object wiring
This mimics how Spring’s ApplicationContext works internally.