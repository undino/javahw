package org.itstep.Servlets;

import org.itstep.Databases.SellerDb;
import org.itstep.Entity.Product;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        String type = new String(req.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");
        String title = new String(req.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));
        int sellerId =  Integer.parseInt(req.getParameter("seller_id"));

        SellerDb sellerDb = new SellerDb();
        String response = sellerDb.addProducts(new Product(type, title, quantity,price, sellerId));
        PrintWriter writer = resp.getWriter();
        writer.println(response);
    }
}
