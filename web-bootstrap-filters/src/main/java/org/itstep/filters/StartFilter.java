package org.itstep.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "startFilter")
public class StartFilter implements Filter {

    private String name;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        name = filterConfig.getFilterName();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Start Start");
        servletResponse.setContentType("text/html");
        servletRequest.setCharacterEncoding("UTF8");
        servletResponse.setCharacterEncoding("UTF8");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("End Start");
    }

    @Override
    public void destroy() {

    }

}
