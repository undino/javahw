package org.itstep.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StoreServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        DynamicPageStore dynamicPageStore = new DynamicPageStore();
        PrintWriter writer = resp.getWriter();
        writer.println(dynamicPageStore.allProducts(Integer.parseInt(req.getParameter("id_for_store")), new String(req.getParameter("login_for_store").getBytes("ISO-8859-1"), "UTF-8"), new String(req.getParameter("password_for_store").getBytes("ISO-8859-1"), "UTF-8")));

    }
}
