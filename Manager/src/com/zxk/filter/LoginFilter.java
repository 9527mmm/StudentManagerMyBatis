package com.zxk.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: JavaWeb0005
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-01 19:06
 **/
@WebFilter("/index.jsp")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String loginname = (String) req.getSession().getAttribute("loginname");
        System.out.println(loginname);
        if (loginname != null) {
            filterChain.doFilter(req, resp);
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }
}
