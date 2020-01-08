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

public class ServletInto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        resp.setContentType("text/html;charset=utf-8");
        CustomerDb customerDb = new CustomerDb();
        SellerDb sellerDb = new SellerDb();
        String login = new String(req.getParameter("login").getBytes("ISO-8859-1"),"UTF-8");
        String password = new String(req.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
        if (req.getParameter("role").equals("CONSUMER")) {
            boolean b = customerDb.find(new Customer(login, password));

            try {
                PrintWriter writer = resp.getWriter();
                if (b) {
                    DynamicPageResponse dynamicPageResponse = new DynamicPageResponse();
                    String request = dynamicPageResponse.customerPage(new Customer(login, password));
                    writer.println(request);
                } else {
                    writer.println("<h1>FALSE</h1>");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (req.getParameter("role").equals("SELLER")){
            boolean b = sellerDb.find(new Seller(login, password));

            try {

                PrintWriter writer = resp.getWriter();
                if (b) {
                    DynamicPageResponse dynamicPageResponse = new DynamicPageResponse();
                    String request = dynamicPageResponse.sellerPage(new Seller(login,password));
                    writer.println(request);

                } else {
                    writer.println("<h1>FALSE</h1>");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

