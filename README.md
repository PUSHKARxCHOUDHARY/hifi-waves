# Hifi Waves – Web-Based Chat Application

Hifi Waves is a fully structured Java-based web application that enables user communication through a shared chat interface.  
The system is developed using **Java Servlets, JSP, JDBC, MySQL, and MVC architecture**, making it ideal for academic submission and demonstration of core Java-based web development concepts.

This project emphasizes:
- Clear problem understanding & design approach  
- Efficient use of Java features  
- Database integration using JDBC  
- Web application development using Servlets & JSP  
- Clean folder structure for maximum marks  

---

## 📖 Project Overview

The main objective of Hifi Waves is to provide a simple, interactive chat room where multiple users can communicate by sending and receiving messages.  
Every message is stored in a MySQL database and displayed in chronological order.

The project is deliberately kept light, clean, and easy to understand so it perfectly fits BCA/MCA/B.Tech Web Technologies submission requirements.

---

## 📁 Project Structure (Detailed)

hifi-waves/
│
├── src/
│ └── com/
│ └── hifi/
│ ├── util/ → DB connection & password hashing helpers
│ ├── model/ → Java POJO classes (User, Message)
│ ├── dao/ → Data Access Objects for SQL operations
│ └── servlet/ → Servlets acting as controllers
│
├── WebContent/
│ ├── jsp/ → Frontend JSP pages
│ ├── css/ → Optional styling
│ └── WEB-INF/ → lib folder + web.xml
│
└── database/ → MySQL schema file

---

## 🎯 Key Features

- User registration with validation  
- Secure login (SHA-256 password hashing)  
- Chat room interface  
- Message storage in MySQL  
- Display of complete message history  
- Session-based user identity  
- MVC-based architecture for clean code separation  
- Servlets handle business logic  
- JSP handles frontend  
- JDBC handles database communication  

---

## 🛠 Technologies Used

### **Backend**
- Java (JDK 8+)
- Servlets
- JDBC
- DAO Pattern
- OOP Concepts

### **Frontend**
- JSP
- HTML & CSS

### **Server**
- Apache Tomcat 9/10

### **Database**
- MySQL

---

## 🗄 Database Setup

Run the SQL file from the `/database/` folder:
