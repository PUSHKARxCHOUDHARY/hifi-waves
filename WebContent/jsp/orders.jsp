<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head><title>Order Page</title></head>
<body>

<h2>Place Your Order</h2>

<p>Welcome, ${sessionScope.username}</p>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<form action="OrderServlet" method="post">
    Product: <input type="text" name="product" required><br><br>
    Amount: <input type="number" name="amount" required><br><br>
    <button type="submit">Place Order</button>
</form>

</body>
</html>
