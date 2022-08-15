package com.JavaBean.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        //get user form info
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");
        //getParameter RegisterFormBean()
        RegisterFormBean formBean = new RegisterFormBean();
        formBean.setName(name);
        formBean.setPassword(password);
        formBean.setPassword2(password);
        formBean.setEmail(email);
        //check form
        if (!formBean.validate()) {
            request.setAttribute("formBean", formBean);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        // getParameter UserBean
        UserBean userBean = new UserBean();
        userBean.setName(name);
        userBean.setPassword(password);
        userBean.setEmail(email);
        boolean b = DBUtil.getInstance().insertUser(userBean);
        if (!b) {
            request.setAttribute("DBMes", "你注册的用户已存在");
            request.setAttribute("formBean", formBean);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        response.getWriter().print("恭喜你注册成功，3秒自动跳转");
        request.getSession().setAttribute("userBean",userBean);
        response.setHeader("refresh","3;url=loginSuccess.jsp");


    }
}
