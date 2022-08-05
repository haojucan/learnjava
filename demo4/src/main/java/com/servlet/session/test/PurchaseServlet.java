package com.servlet.session.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PurchaseServlet", value = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户购买的商品
        String id = request.getParameter("id");
        if (id == null) {
            //如果id为null， 重定向到ListBookServlet页面
            String url = "/demo4_war_exploded/ListBookServlet";
            response.sendRedirect(url);
            return;
        }
        Book book = BookDB.getBook(id);

        //创建或者获取用户Session对象
        HttpSession session = request.getSession();
        //从Session获取用户的购物车
        response.getWriter().print("3333");

        List<Book> cart = (List) session.getAttribute("xscart");
        if (cart == null) {
              response.getWriter().print("00000");
            //首次购买
            cart = new ArrayList<Book>();
            //将购物车存入Session对象
            session.setAttribute("xscart", cart);
        }
            //将商品放于购物车
            cart.add(book);
            response.getWriter().print(6666);
            //创建Cookie 存放Session 的标示号
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(60 * 30);
//            cookie.setPath("/demo4_war_exploded");
            response.addCookie(cookie);
            //重定向购物车页面
            String url = "/demo4_war_exploded/CartServlet";
            response.sendRedirect(url);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
