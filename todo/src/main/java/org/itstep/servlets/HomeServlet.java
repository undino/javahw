package org.itstep.servlets;

import org.itstep.db.ToDoDao;
import org.itstep.entity.ToDo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Queue;

@WebServlet(urlPatterns = "/", name = "homeServlet")
public class HomeServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shortDescription = request.getParameter("short_description");
        String longDescription = request.getParameter("long_description");
        String dateStart = request.getParameter("start_todo");
        String dateEnd = request.getParameter("end_todo");
        int priority = Integer.parseInt(request.getParameter("priority"));

        System.out.println(shortDescription);
        System.out.println(longDescription);
        System.out.println(dateStart);
        System.out.println(dateEnd);
        System.out.println(priority);
        ToDoDao toDoDao = (ToDoDao) getServletContext().getAttribute("toDoDao");
        toDoDao.add(new ToDo(shortDescription, longDescription, dateStart, dateEnd, priority, 2));
        response.sendRedirect("/");
    }
}
