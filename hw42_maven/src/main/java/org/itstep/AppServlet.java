package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppServlet extends HttpServlet {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    final static String connString = "jdbc:mysql://localhost/usersdb?serverTimezone=Europe/Kiev&characterEncoding=utf8";
    final static String userdb = "root";
    final static String passworddb = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        try (Connection conn = DriverManager.getConnection(connString, userdb, passworddb)) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, login, password from user");
            writer.write("<h1>User list</h1>");
            writer.write("<table>");
            while (rs.next()) {
                writer.write("<tr>");
                writer.write("<td>" + rs.getInt("id") + "</td>");
                writer.write("<td>" + rs.getString("login") + "</td>");
                writer.write("<td>" + rs.getString("password") + "</td>");
                writer.write("</tr>");
            }
            writer.write("</table>");
        } catch (SQLException ex) {
            writer.write("<h2 style='color: red'>Error: " + ex.getLocalizedMessage() + "</h2>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String loginUser = req.getParameter("login");
        String passwordUser = req.getParameter("password");

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        try (Connection conn = DriverManager.getConnection(connString, userdb, passworddb)) {

            Statement stmt = conn.createStatement();

            String sql = "insert into user (login, password) values ('" + loginUser + "', '" + passwordUser + "')";

            stmt.executeUpdate(sql);
            writer.write(
                    "OK. Your Browser reload after 3 seconds. <script>setTimeout(() => window.location='App', 3000)</script>");

        } catch (SQLException e) {
            writer.write("<h2 style='color: red'>Error: " + e.getLocalizedMessage() + "</h2>");
        }
    }
}
