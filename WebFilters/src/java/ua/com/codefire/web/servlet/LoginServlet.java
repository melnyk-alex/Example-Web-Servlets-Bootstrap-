/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.web.servlet;

import ua.com.codefire.web.util.URLUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author human
 */
@WebServlet({"/login", "/logout"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/logout".equals(req.getServletPath())) {

            req.getSession().invalidate();

            resp.sendRedirect(req.getHeader("referer"));
        } else {
            super.doPost(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/login".equals(req.getServletPath())) {

            String username = req.getParameter("username");
            String password = req.getParameter("password");

            if ("user".equals(username) && "12345".equals(password)) {
                req.getSession().setAttribute("username", username);
            }

            resp.sendRedirect(req.getHeader("referer"));
        } else {
            super.doPost(req, resp);
        }
    }

}
