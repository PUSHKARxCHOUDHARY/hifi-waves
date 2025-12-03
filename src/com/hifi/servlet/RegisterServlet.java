package com.hifi.servlet;

import com.hifi.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final UserDAO dao = new UserDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("jsp/register.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email    = req.getParameter("email");

        if (dao.registerUser(username, password, email)) {
            resp.sendRedirect("login");
        } else {
            req.setAttribute("msg", "Registration failed");
            req.getRequestDispatcher("jsp/register.jsp").forward(req, resp);
        }
    }
}
