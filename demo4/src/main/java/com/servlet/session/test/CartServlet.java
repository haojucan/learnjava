package com.servlet.session.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        //变量cart 引用用户购物车
        List<Book> cart = null;
        //变量purFlag标记用户是否买过商品
        boolean purFlag = true;
        //获取用户的Session
        HttpSession session = request.getSession(false);
        //如果Session 为null,purFlag置为false
        if (session == null) {
            purFlag = false;
        } else {
            //获取用户购物车
            cart = (List) session.getAttribute("xscart");
            if (cart == null) {
                purFlag = false;
            }
        }
        //如purFlag 等false 说明没有购买过图书，重定向到ListBookServlet页面
        if (!purFlag) {
            out.write("对不起！您还没有购买任何商品！ <br />");
        } else {
            //否则显示用户购买图书的信息
            out.write("您购买的图书的有：<br />");
            double price =0;
            for (Book book: cart) {
                out.write(book.getName() +"<br />");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
