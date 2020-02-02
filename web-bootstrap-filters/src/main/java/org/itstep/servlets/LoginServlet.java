package org.itstep.servlets;

import org.itstep.dao.DbUsers;
import org.itstep.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login", name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/home/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String pathRole = "";
        System.out.println("User in Log in = " + user);

        if (user != null)
            switch (user.getRole()) {
                case ADMIN:
                    pathRole = "/admin";
                    break;
                case SIMPLE_USER:
                    pathRole = "/user";
                    break;
                default:
                    System.err.println("--SWITCH-- has a problem ");
                    break;
            }

        if (user == null) {
            System.out.println("path in SERVLET = " + pathRole);
            response.sendRedirect(getServletContext().getContextPath() + "/registration");
        } else {
            response.sendRedirect(getServletContext().getContextPath() + pathRole);
        }

    }

}

