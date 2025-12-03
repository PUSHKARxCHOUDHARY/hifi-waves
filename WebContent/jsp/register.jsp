<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register - HiFi Waves</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f0f2f5; }
        .container { width: 400px; margin: 100px auto; padding: 20px; background: white; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h2 { text-align: center; }
        input[type=text], input[type=password], input[type=email] { width: 100%; padding: 10px; margin: 10px 0; border-radius: 4px; border: 1px solid #ccc; }
        button { width: 100%; padding: 10px; background: #28a745; color: white; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background: #218838; }
        .error { color: red; text-align: center; }
        .link { text-align: center; margin-top: 10px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Register</h2>
        <form action="register" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="email" name="email" placeholder="Email" required>
            <button type="submit">Register</button>
        </form>
        <div class="error">
            <% if(request.getAttribute("errorMessage") != null) { %>
                <%= request.getAttribute("errorMessage") %>
            <% } %>
        </div>
        <div class="link">
            <a href="login.jsp">Already have an account? Login</a>
        </div>
    </div>
</body>
</html>
