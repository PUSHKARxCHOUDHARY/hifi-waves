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
</body>
</html>
