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

/**
 *
 * @author human
 */
@WebServlet("/downloads")
public class DownloadsServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<UploadFile> uploadFileList = 
//        uploadFileList.reverse();
//        req.setAttribute("fileList", uploadFileList);

        req.getRequestDispatcher(URLUtil.getWebViewPath("downloads.jsp")).forward(req, resp);
    }
    
}
