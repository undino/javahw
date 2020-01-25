package org.itstep;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@WebServlet("/traffic")
public class ServletProcessing extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // Список для хранения значений кнопок для определения запроса пользователя и передачи в swish
        List<String> listButton = new LinkedList<>();

        listButton.add(req.getParameter("create"));
        listButton.add(req.getParameter("new"));
        listButton.add(req.getParameter("delete"));

        Optional<String> value = listButton.stream().filter(e -> e != null).findFirst();

        Cookie cookie;
        Cookie[] cookies = req.getCookies();

        PrintWriter writer = resp.getWriter();
        outSwitch:

        switch (value.get()) {

            case "create":
                for (Cookie c : cookies) {
                    if (c.getName().equals(req.getParameter("create_key"))) {
                        writer.println("<h4>" + "Кук уже существует" + "</h4>");
                        break outSwitch;
                    }
                }

                cookie = new Cookie(req.getParameter("create_key"), req.getParameter("create_value"));

                if (req.getParameter("create_lifetime").length() > 0)
                    cookie.setMaxAge((Integer.parseInt(req.getParameter("create_lifetime"))));

                if (req.getParameter("create_domen").length() > 0)
                    cookie.setDomain(req.getParameter("create_domen"));

                if ("on".equals(req.getParameter("create_secure")))
                    cookie.setSecure(true);

                resp.addCookie(cookie);
                resp.sendRedirect("index.jsp");
                break;

            case "new":
                for (Cookie c : cookies) {

                    if (c.getName().equals(req.getParameter("set_key"))) {

                        if (req.getParameter("set_value").length() > 0)
                            c.setValue(req.getParameter("set_value"));

                        if (req.getParameter("set_lifetime").length() > 0)
                            c.setMaxAge(Integer.parseInt(req.getParameter("set_lifetime")));

                        if (req.getParameter("set_domen").length() > 0)
                            c.setDomain(req.getParameter("set_domen"));

                        if ("on".equals(req.getParameter("set_secure")))
                            c.setSecure(true);

                        resp.addCookie(c);
                        resp.sendRedirect("index.jsp");
                        break outSwitch;
                    }

                }
                writer.println("<h4>" + "Кук не найден" + "</h4>");

                break;
            case "delete":
                for (Cookie c : cookies) {
                    if (c.getName().equals(req.getParameter("delete_key"))) {
                        c.setMaxAge(0);
                        resp.addCookie(c);
                        resp.sendRedirect("index.jsp");
                        break outSwitch;
                    }
                }
                writer.println("<h4>" + "Кук не найден" + "</h4>");
                break;
            default:
                break;
        }

    }

}
