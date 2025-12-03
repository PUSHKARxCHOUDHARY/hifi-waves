import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class OrderServlet extends HttpServlet {

    private OrderDAO orderDAO = new OrderDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String username = (String) session.getAttribute("username");
        String product = request.getParameter("product");
        int amount = Integer.parseInt(request.getParameter("amount"));

        boolean success = orderDAO.addOrder(username, product, amount);

        if (success) {
            response.sendRedirect("orderSuccess.jsp");
        } else {
            request.setAttribute("error", "Failed to place order");
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        }
    }
}
