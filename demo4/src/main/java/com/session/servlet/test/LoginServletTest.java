package com.session.servlet.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServletTest", value = "/LoginServletTest")
public class LoginServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("测试请求");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("check_code");
        String saveCode = (String) request.getSession().getAttribute("check_code");
        PrintWriter pw = response.getWriter();
        if (("itcast").equals(username) && ("123").equals(password) && checkCode.equals(saveCode)){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/demo4_war_exploded/IndexServlet");

        }else if (checkCode.equals(saveCode)){
            pw.print("用户帐号或者密码错误");
        }else {
            pw.print("验证码错误");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }
}
