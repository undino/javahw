package org.itstep;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String loginUser = req.getParameter("login");
        String passwordUser = req.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String connString = "jdbc:mysql://localhost/usersdb?serverTimezone=Europe/Kiev&characterEncoding=utf8";
        String userdb = "root";
        String passworddb = "";
        try (Connection conn = DriverManager.getConnection(connString, userdb, passworddb)) {

            Statement stmt = conn.createStatement();

            String sql = "insert into user (login, password) values ('" + loginUser + "', '" + passwordUser +"')";

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
