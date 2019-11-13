package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class AppServlet extends HttpServlet {
    private String LOGIN = "admin";
    private String PASSWORD = "admin";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Map<String, String> mapUsers = new HashMap<>();
        mapUsers.put("vas9666", "123456");
        mapUsers.put("diamon", "gtgtr");
        mapUsers.put("foar1313", "qwerqwer");
        mapUsers.put("SimSam", "1111");
        mapUsers.put("Doniel", "4444");
        mapUsers.put("lili_13", "15151515");
        mapUsers.put("digbag", "gotogo");


        PrintWriter writer = resp.getWriter();
        if (LOGIN.equals(login) & PASSWORD.equals(password)) {

            writer.println("<table style='border: 1px solid black; border-spacing: 0'>");
            writer.println("<caption>TABLE IS USERS</caption>");
            writer.print("<thead><tr><th>User login</th><th>User password</th></thead>");
            for (Map.Entry<String, String> map : mapUsers.entrySet()) {
                writer.println("<tr><td style='border: 1px solid black'> " +  map.getKey() + "</td> <td style='border: 1px solid black'> " + map.getValue() + "</td></tr>");
            }
            writer.println("</table>");
        } else {
            writer.println(login + " = " + password);
            writer.println("You entered incorrect data");
        }
    }
}
