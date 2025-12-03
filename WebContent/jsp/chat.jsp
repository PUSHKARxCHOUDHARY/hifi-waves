<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.hifi.model.Message" %>

<html>
<head>
<title>Chat Room</title>
</head>

<body>
<h2>Welcome, <%= session.getAttribute("uname") %></h2>
<h3>Chat Room</h3>

<div style="border:1px solid #ccc; padding:10px; width:60%; height:300px; overflow:auto;">
    <%
        List<Message> list = (List<Message>) request.getAttribute("messages");
        if(list != null){
            for(Message m : list){
    %>
        <p><b><%= m.getUsername() %>:</b> <%= m.getText() %></p>
    <%
            }
        }
    %>
</div>

<br>

<form action="chat" method="post">
    <input name="text" placeholder="Type message" required style="width:300px;" />
    <button type="submit">Send</button>
</form>

<br>
<a href="logout">Logout</a>

</body>
</html>
