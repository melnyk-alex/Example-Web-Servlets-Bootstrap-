/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.web.servlet;

import ua.com.codefire.web.util.URLUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.codefire.web.db.controller.ArticleController;
import ua.com.codefire.web.db.entity.Article;

/**
 *
 * @author human
 */
@WebServlet("/articles")
public class ArticlesServlet extends HttpServlet {
    
    private ArticleController articleController;

    @Override
    public void init() throws ServletException {
        this.articleController = new ArticleController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articleList = articleController.getArticleList();
        
        req.setAttribute("articleList", articleList);
        
        req.getRequestDispatcher(URLUtil.getWebViewPath("articles.jsp")).forward(req, resp);
    }
    
}
