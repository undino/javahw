package org.itstep;

import org.itstep.dao.UserDao;
import org.itstep.domain.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class UserServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String user = getServletContext().getInitParameter("db.username");
        String pass = getServletContext().getInitParameter("db.password");
        String url = getServletContext().getInitParameter("db.url");
        try {
            userDao = new UserDao(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String login = req.getParameter("loginIn");
        String password = req.getParameter("passwordIn");
        User user = new User(login, password);
        if (userDao != null) {
            userDao.save(user);
        }
        List<User> listUser = userDao.findAll();
        PrintWriter writer = resp.getWriter();
        if (listUser.indexOf(new User(login, password)) >= 0) {
            writer.println("<h2>Вы успешно вошли</h2>");
        } else {
            writer.println("<h2>Попытка входа не уадалась</h2>");
        }
    }
}
