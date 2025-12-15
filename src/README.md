# Source Code Directory

The `src` folder contains all Java-based backend logic for the application.  
All packages follow the Model–View–Controller (MVC) pattern for clean separation of concerns.

This ensures maintainability, clarity, and professional project structure.

---

## Package Breakdown

### 1. util  
Includes helper utilities such as database configuration and password hashing.

### 2. model  
Contains Java POJO classes representing database entities (User, Message).

### 3. dao  
Implements the Data Access Object pattern to handle SQL queries.

### 4. servlet  
Acts as the controller layer, processing user requests and routing data between DAO and JSP.
