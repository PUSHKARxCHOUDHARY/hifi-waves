package com.hifi.servlet;

import com.hifi.dao.MessageDAO;
import com.hifi.model.Message;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

    MessageDAO dao = new MessageDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Message> messages = dao.getAllMessages();
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("jsp/chat.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        int uid = (int) session.getAttribute("uid");
        String uname = (String) session.getAttribute("uname");

        String text = req.getParameter("text");

        dao.saveMessage(uid, uname, text);

        resp.sendRedirect("chat");
    }
}
