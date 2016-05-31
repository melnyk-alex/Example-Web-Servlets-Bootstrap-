/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.web.util;

/**
 *
 * @author human
 */
public class URLUtil {

    public static final String WEB_VIEWS = "/WEB-INF/jsp";
    
    public static String getWebViewPath(String filename) {
        return String.format("%s/%s", WEB_VIEWS, filename);
    }
}
