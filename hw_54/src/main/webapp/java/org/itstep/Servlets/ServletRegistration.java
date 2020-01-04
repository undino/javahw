package org.itstep.Servlets;


import org.itstep.Databases.CustomerDb;
import org.itstep.Databases.SellerDb;
import org.itstep.Entity.Customer;
import org.itstep.Entity.Seller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class ServletRegistration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        resp.setContentType("text/html;charset=utf-8");
        String role = req.getParameter("role");
        String login = new String(req.getParameter("login").getBytes("ISO-8859-1"),"UTF-8");
        String password = new String(req.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
        if (role.equals("CONSUMER")) {
            CustomerDb customerDb = new CustomerDb();
            customerDb.add(new Customer(login, password));
        } else {
            SellerDb sellerDb = new SellerDb();
            sellerDb.add(new Seller(login, password));
        }

        try {
            PrintWriter writer = resp.getWriter();
            resp.sendRedirect("../html/into_form.html");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
