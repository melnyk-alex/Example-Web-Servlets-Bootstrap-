/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author human
 */
@WebFilter("/*")
public class GeneralFilter implements Filter {

    private List<String> exceptList;
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;

        exceptList = new ArrayList<>();
        exceptList.add("/");
        exceptList.add("/index");
        exceptList.add("/login");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        HttpServletResponse resp = (HttpServletResponse) response;

        String username = (String) session.getAttribute("username");

        if (username != null && !username.isEmpty() || req.getServletPath().startsWith("/assets") || exceptList.contains(req.getServletPath())) {
            chain.doFilter(request, response);
        } else {
            resp.sendError(403);
        }
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }

}
