package org.itstep.servlets;

import org.itstep.db.ToDoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete",name = "DeleteToDoServlet")
public class DeleteToDoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        ToDoDao toDoDao = (ToDoDao) getServletContext().getAttribute("toDoDao");
        toDoDao.delete(id);
        response.sendRedirect("/");

    }

}
