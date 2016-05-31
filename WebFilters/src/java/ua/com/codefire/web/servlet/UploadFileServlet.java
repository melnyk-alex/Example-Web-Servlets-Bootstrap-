/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author human
 */
@WebServlet("/upload")
public class UploadFileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Part uploadPart = req.getPart("upload");
        
        if (uploadPart.getSize() > 0) {
            String submittedFileName = uploadPart.getSubmittedFileName();
            uploadPart.write("/Users/human/Downloads/" + submittedFileName);
        }
        
        resp.sendRedirect("./downloads");
    }
    
}
