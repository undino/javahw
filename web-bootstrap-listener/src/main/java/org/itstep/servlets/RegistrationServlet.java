package org.itstep.servlets;

import org.itstep.dao.DbUsers;
import org.itstep.entity.Role;
import org.itstep.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration", name = "registration")
public class RegistrationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/home/registration.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login").toLowerCase();
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        if (login != null && password != null && role != null) {
            DbUsers dbUsers = new DbUsers();
            if ("admin".equals(role)) {
                dbUsers.addUser(new User(login, password, Role.ADMIN));
                response.sendRedirect(getServletContext().getContextPath() + "/login");
            } else {
                dbUsers.addUser(new User(login, password, Role.SIMPLE_USER));
                response.sendRedirect(getServletContext().getContextPath() + "/login");
            }
        }

    }
}
