package org.itstep.Servlets;

import org.itstep.Databases.TransactionDb;
import org.itstep.Entity.Customer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletTransaction extends HttpServlet {
    private int customerId;
    private int sellerId;
    private int productId;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        customerId = Integer.parseInt(req.getParameter("customerId"));
        sellerId = Integer.parseInt(req.getParameter("sellerId"));
        productId = Integer.parseInt(req.getParameter("productId"));

        TransactionDb transactionDb = new TransactionDb();
        boolean b = transactionDb.transactionStore(customerId, sellerId, productId);
        PrintWriter writer = resp.getWriter();
        if (b) {
            DynamicPageResponse dynamicPageResponse = new DynamicPageResponse();
            String login = new String(req.getParameter("login_for_store").getBytes("ISO-8859-1"),"UTF-8");
            String password = new String(req.getParameter("password_for_store").getBytes("ISO-8859-1"),"UTF-8");
            String request = dynamicPageResponse.customerPage(new Customer(login, password));
            writer.println(request);
        } else {
            writer.println("FALSE TRANSACTION");
        }

    }
}
