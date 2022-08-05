<%@ page import="static java.lang.System.out" %><%--
  Created by IntelliJ IDEA.
  User: axu
  Date: 2022/8/4
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
int a = 1
        ,
        b = 2;
%>
<%!
    public String print() {
        String str = "itcast";
        return str;
    }
%>
<%
   out.println(a +b);
%>
<br />
<%
    out.println(print()); //调用print()方法，输出其返回值
%>
</body>
</html>
