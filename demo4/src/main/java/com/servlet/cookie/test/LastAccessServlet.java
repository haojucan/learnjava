package com.servlet.cookie.test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LastAccessServlet", value = "/LastAccessServlet")
public class LastAccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String lastAccessTime = null;
        //获取所有cookies 数组
        Cookie[] cookies = request.getCookies();
        //遍历所有cookies数组
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("lastAccess".equals(cookies[i].getName())){
                lastAccessTime = cookies[i].getValue();
                break;
            }
        }
        System.out.println(lastAccessTime);

        //判断是否存在名称为lastAccess的cookie
        if (lastAccessTime == null){
            response.getWriter().println("您首次访问本网站");
        }else{
            response.getWriter().println("您上次访问的时间是：" +lastAccessTime);
        }
        //创建cookie，将当前的时间在作为cookie的值发送给客户端
        String currentTime = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss").format(new Date());
        System.out.println(currentTime);
        Cookie  ck = new Cookie("lastAccess",currentTime);
        //发送cookie
        response.addCookie(ck);
        System.out.println(lastAccessTime);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
