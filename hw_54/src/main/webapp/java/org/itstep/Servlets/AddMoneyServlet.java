package org.itstep.Servlets;

import org.itstep.Databases.CustomerDb;
import org.itstep.Entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddMoneyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        CustomerDb customerDb = new CustomerDb();
        String login = new String(req.getParameter("login").getBytes("ISO-8859-1"),"UTF-8");
        String password = new String(req.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
        Customer customer = new Customer(login, password);

        if (customerDb.find(customer)) {
            boolean b = customerDb.addMoney(customer, Double.parseDouble(req.getParameter("addMoney")));
            if (b) {
                DynamicPageResponse dynamicPageResponse = new DynamicPageResponse();
                PrintWriter writer = resp.getWriter();
                writer.println(dynamicPageResponse.customerPage(customer));
            }
        }

    }
}
