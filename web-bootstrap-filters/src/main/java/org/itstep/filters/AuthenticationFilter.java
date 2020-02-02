package org.itstep.filters;

import org.itstep.dao.DbUsers;
import org.itstep.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/login", filterName = "authentication")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        servletRequest.setCharacterEncoding("UTF8");
        servletResponse.setCharacterEncoding("UTF8");
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        String method = ((HttpServletRequest) servletRequest).getMethod();

        if ("POST".equals(method)) {

            String login = servletRequest.getParameter("login").toLowerCase();
            String password = servletRequest.getParameter("password");
            System.out.println("Login and password in A_S");
            System.out.println(login);
            System.out.println(password);
            DbUsers dbUsers = new DbUsers();
            User user = dbUsers.getUser(new User(login, password));
            System.out.println("User into A_SERVLET = " + user);
            if (user != null) {
                session.setAttribute("user", user);
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }

        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
