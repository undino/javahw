package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numCard = req.getParameter("numCard");
        String nameOnCard = req.getParameter("nameOnCard");


//        Enumeration<String> en = req.getParameterNames();
//        while (en.hasMoreElements()) {
//            String item = en.nextElement();
//            String[] value = req.getParameterValues(item);
            System.out.println(numCard + " = " + nameOnCard);
//        }
    }
}
