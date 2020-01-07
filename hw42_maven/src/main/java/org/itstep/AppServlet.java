package org.itstep;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppServlet extends HttpServlet {

    static final String connString = "jdbc:mysql://localhost/usersdb?serverTimezone=Europe/Kiev&characterEncoding=utf8";
    static final String userdb = "root";
    static final String passworddb = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String loginUser = req.getParameter("login");
        String passwordUser = req.getParameter("password");

        // Нужно проверять на null значения получаемые от пользователя (loginUser и
        // passwordUser) перед сохранением в базу данных

        try (Connection conn = DriverManager.getConnection(connString, userdb, passworddb)) {

            Statement stmt = conn.createStatement();

            // возможны sql инъекция
            String sql = "insert into user (login, password) values ('" + loginUser + "', '" + passwordUser + "')";

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // что после регистрации? нужно выдавать страницу с сообщением об успешной
        // регистрацией
    }
}
