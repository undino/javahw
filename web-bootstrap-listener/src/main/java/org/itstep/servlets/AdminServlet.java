package org.itstep.servlets;

import org.itstep.entity.User;
import org.itstep.listeners.CounterUsersListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin", name = "AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        getServletContext().setAttribute("count", CounterUsersListener.countListener);
        if (user != null && "ADMIN".equals(user.getRole().toString())) {
            request.getRequestDispatcher("/WEB-INF/home/admin.jsp").forward(request, response);
        } else {
            response.sendRedirect(getServletContext().getContextPath() + "/registration");
        }

    }

}
