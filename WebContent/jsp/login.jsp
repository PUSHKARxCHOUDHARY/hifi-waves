<<<<<<< HEAD
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title>Login</title>
</head>
<body>
<h2>Login</h2>

<% if(request.getAttribute("msg") != null){ %>
<p style="color:red"><%= request.getAttribute("msg") %></p>
<% } %>

<form action="login" method="post">
    <input name="username" placeholder="Username" required /><br><br>
    <input type="password" name="password" placeholder="Password" required /><br><br>
    <button type="submit">Login</button>
</form>

<br>
<a href="register">Create new account</a>
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>

<h2>Login</h2>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<form action="LoginServlet" method="post">
    Username: <input type="text" name="username" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <button type="submit">Login</button>
</form>

>>>>>>> 12795ffb2abf94f6bc5baffb7aaec6f20ec1aca1
</body>
</html>

