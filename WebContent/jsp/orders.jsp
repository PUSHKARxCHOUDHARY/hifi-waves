<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Orders - HiFi Waves</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f0f2f5; }
        .container { width: 800px; margin: 50px auto; padding: 20px; background: white; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h2 { text-align: center; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        table, th, td { border: 1px solid #ccc; }
        th, td { padding: 10px; text-align: center; }
        input, button { padding: 8px; margin: 5px; border-radius: 4px; }
        button { background: #007bff; color: white; border: none; cursor: pointer; }
        button:hover { background: #0056b3; }
        .error { color: red; text-align: center; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome, <%= session.getAttribute("username") %></h2>

        <h3>Add New Order</h3>
        <form action="orders" method="post">
            <input type="hidden" name="userId" value="1"> <!-- Replace with real user ID -->
            <input type="text" name="productName" placeholder="Product Name" required>
            <input type="number" name="quantity" placeholder="Quantity" required>
            <button type="submit">Add Order</button>
        </form>

        <div class="error">
            <% if(request.getAttribute("errorMessage") != null) { %>
                <%= request.getAttribute("errorMessage") %>
            <% } %>
        </div>

        <h3>Your Orders</h3>
        <table>
            <tr>
                <th>Order ID</th>
                <th>Product Name</th>
                <th>Quantity</th>
            </tr>
            <%
                ResultSet rs = (ResultSet) request.getAttribute("orders");
                if (rs != null) {
                    while(rs.next()) {
            %>
            <tr>
                <td><%= rs.getInt("id") %></td>
                <td><%= rs.getString("product_name") %></td>
                <td><%= rs.getInt("quantity") %></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>
</body>
</html>
