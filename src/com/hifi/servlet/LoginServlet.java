package com.hifi.servlet;

import com.hifi.dao.UserDAO;
import com.hifi.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserDAO dao = new UserDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = dao.login(username, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("uid", user.getId());
            session.setAttribute("uname", user.getUsername());
            resp.sendRedirect("chat");
        } else {
            req.setAttribute("msg", "Wrong username/password");
            req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
        }
    }
}
