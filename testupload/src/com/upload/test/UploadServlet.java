package com.upload.test;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UploadServlet", value = "/UploadServlet")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        File f = new File("/Users/axu/IdeaProjects/learnjavaweb/testupload/TempFolder");
        if (!f.exists()) {
            boolean mkdirs = f.mkdirs();
        }
        //设置文件的缓存路径
        factory.setRepository(f);
        //创建ServletFileUpload对象
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //设置编码
        fileUpload.setHeaderEncoding("utf-8");
        //解析request，得到上传文件的FileItem对象
        try {
            List<FileItem> fileItems = fileUpload.parseRequest(request);
            //获取字符流
            PrintWriter writer = response.getWriter();
            //遍历集合
            for (FileItem fileItem : fileItems) {
                //判断是否为普通字段
                if (fileItem.isFormField()) {
                    //获取字段名和字段值
                    String name = fileItem.getFieldName();
                    if (name.equals("name")) {
                        //如果文件不为空，将其保存在value中
                        if (!fileItem.getString().equals("")) {
                            String value = fileItem.getString("utf-8");
                            writer.println("上传者" + value + "<br />");
                        }
                    }
                } else {
                    // get file name
                    String filename = fileItem.getName();
                    //handle Upload file
                    if (filename != null && !filename.equals("")) {
                        writer.println("upload file name is" + filename + "<br>");
                    }
                    //substring file name
                    filename = filename != null ? filename.substring(filename.lastIndexOf("\\" + 1)) : null;
                    //file name unique 
                    filename = UUID.randomUUID().toString() + "_" + filename;
                    //hostname build equals file
                    String webPath = "/upload";
                    String filepath = getServletContext().getRealPath(webPath + filename);
                    // build file
                    File file = new File(filepath);
                    boolean mkdirs = file.getParentFile().mkdirs();
                    boolean newFile = file.createNewFile();
                    //get upload stream
                    InputStream in = fileItem.getInputStream();
                    //使用FileOutputStream 打开服务器端的上传文件

                    FileOutputStream out = new FileOutputStream(file);
                    //流的对拷
                    byte[] buffer = new byte[1024];
                    int len;
                    //开始读取上传文件的字节，并将其输出到服务端的上传文件输出流
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                        //关闭流
                        in.close();
                        out.close();
                        //删除临时文件
                        fileItem.delete();
                        writer.println(" 上传文件成功！<br />");
                    }
                }
            }
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
