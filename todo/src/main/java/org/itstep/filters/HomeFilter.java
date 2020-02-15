package org.itstep.filters;

import org.itstep.db.ToDoDao;
import org.itstep.entity.ToDo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Queue;

@WebFilter(servletNames = "homeServlet", filterName = "HomeFilter")
public class HomeFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        ToDoDao toDoDao = (ToDoDao) context.getAttribute("toDoDao");
        Queue<ToDo> queue = toDoDao.getAll();
        req.setAttribute("queue", queue);

        System.out.println("start filter");
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF8");
        resp.setCharacterEncoding("UTF8");
        chain.doFilter(req, resp);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF8");
        req.setCharacterEncoding("UTF8");
        System.out.println("end filter");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
