package com.session.servlet.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session  = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user==null){
            response.getWriter().print("您还没登录，请 <a href='/demo4_war_exploded/login.html'>登录</a>");
        }else {
            response.getWriter().print("登录成功，欢迎你，"+user.getUsername());
            response.getWriter().print("<a href='/demo4_war_exploded/LogoutServlet'>退出</a>");
            //创建Cookie 用于存放Session的标识号
            Cookie cookie = new Cookie("xJSESSIONID",session.getId());
            cookie.setMaxAge(60*3);
            cookie.setPath("/demo4/demo4_war_exploded");
            response.addCookie(cookie);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }
}
