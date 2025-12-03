# HiFi Waves – Web Chat & Order Management System

## Overview
HiFi Waves is a web application that allows users to **register, login, and manage orders**.  
The project uses **Java Servlets, JSP, and JDBC** for backend operations with a **MySQL database**.

---

## Project Structure

hifi-waves/
├─ backend/
│ └─ java/
│ ├─ DBConnection.java
│ ├─ UserDAO.java
│ ├─ OrderDAO.java
│ ├─ LoginServlet.java
│ ├─ RegisterServlet.java
│ └─ OrderServlet.java
├─ frontend/
│ └─ jsp/
│ ├─ login.jsp
│ ├─ register.jsp
│ └─ orders.jsp
└─ database/
└─ schema.sql

---

## Features

- **User Registration & Login**  
- **Session management** (HttpSession)  
- **Add & view orders**  
- **JDBC integration** with MySQL  
- **Servlets & JSP for web interface**

---

## Prerequisites

- Java JDK 8+  
- Apache Tomcat 9+  
- MySQL 5.7+  
- IDE (Eclipse / IntelliJ / NetBeans)  

---

## Setup Instructions

1. **Database Setup**
   - Open `database/schema.sql` and execute it in MySQL.
   - This creates `hifi_waves` database with `users` and `orders` tables.

2. **Backend Setup**
   - Place all `.java` files inside `backend/java/` in your project.
   - Compile Java files and deploy to Tomcat.

