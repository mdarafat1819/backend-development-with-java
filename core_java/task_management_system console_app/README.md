# Simple Task Management System

## Objective  
This is a simple console-based Task Management System built using **Core Java**.  
The main goal of this project is to practice and demonstrate basic Java concepts such as:

- Object-Oriented Programming (OOP)  
- Collections  
- Enums  
- User input handling (`Scanner`)  

No database or external frameworks are used.

---

## 🧩 Task Details  

Each task contains the following fields:

- **id** (int)  
- **title** (String)  
- **description** (String)  
- **status** (Enum)  
  - `PENDING`  
  - `IN_PROGRESS`  
  - `DONE`  

---

## 🚀 Features  
**Press 0:** Display Menu</br>
**Press 1:** Add new task</br>
**Press 2:** Update task status</br>
**Press 3:** Display All Tasks</br>
**Press 4:** Delete a task</br>
**Press 5:** Exit</br>
**Press 6:** Clear Terminal</br>

---

## 🛠 Technical Guidelines  

- Core Java only  
- Uses:
  - `class` and `object`
  - `enum` for task status  
  - `ArrayList` for in-memory storage  
  - `Scanner` for user input  
- No database  
- No frameworks  
- Clean and readable code structure  

---
## ✅ Pre-requisites  
- **JDK 21** (Java Development Kit 21)  
- Any IDE (IntelliJ IDEA, Eclipse, VS Code) or command-line terminal 
## ▶ How to Run  
   ```bash
   git clone https://github.com/mdarafat1819/backend-development-with-java.git
   cd backend-development-with-java/core_java/"task_management_system console_app"
   javac Stms.java
   java Stms
