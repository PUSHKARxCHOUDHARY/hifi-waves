package java_backend;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderDAO orderDAO = new OrderDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = Integer.parseInt(request.getParameter("userId"));
        String productName = request.getParameter("productName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        boolean isAdded = orderDAO.addOrder(userId, productName, quantity);
        if (isAdded) {
            response.sendRedirect("orders.jsp");
        } else {
            request.setAttribute("errorMessage", "Failed to add order");
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = Integer.parseInt(request.getParameter("userId"));
        try {
            ResultSet rs = orderDAO.getOrdersByUser(userId);
            request.setAttribute("orders", rs);
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Error fetching orders: " + e.getMessage());
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        }
    }
}
