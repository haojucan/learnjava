package com.download.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //set contentType key value
        response.setContentType("text/html;charset=utf-8");
        //get download file name
        String filename = request.getParameter("filename");
        //download file dir
        String folder = "/WEB-INF/classes/download/";
        //Notify the browser to open as a download
        response.setHeader("Content-Type", "application/octet-stream");
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        // read file for stream
        InputStream in = getServletContext().getResourceAsStream(folder + filename);
        //get response object OutputStream
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer,0, len);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
