package com.servlet.session.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "ListBookServlet", value = "/ListBookServlet")
public class ListBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Collection<Book> books = BookDB.getAll();
        out.print("本站提供的图书有：<br />");
        for (Book book : books) {
            String url = "/demo4_war_exploded/PurchaseServlet?id=" + book.getId();
            out.write(book.getName() + "<a href='" + url + "'> 点击购买</a></br />");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
