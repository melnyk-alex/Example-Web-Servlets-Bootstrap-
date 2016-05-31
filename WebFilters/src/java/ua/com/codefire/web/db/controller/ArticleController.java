/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.web.db.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ua.com.codefire.web.db.entity.Article;

/**
 *
 * @author human
 */
public class ArticleController extends BaseController {

    public List<Article> getArticleList() {
        EntityManager manager = getManager();
        
        try {
            TypedQuery<Article> query = manager.createQuery("SELECT a FROM Article a", Article.class);
            
            List<Article> resultList = query.getResultList();
            
            return resultList;
        } finally {
            manager.close();
        }
    }

}
