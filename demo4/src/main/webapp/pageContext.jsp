<%--
  Created by IntelliJ IDEA.
  User: axu
  Date: 2022/8/4
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  //获取request 对象
  HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
  //设置page范围内属性
  pageContext.setAttribute("str","Java", PageContext.PAGE_SCOPE);
  //设置request范围属性
  req.setAttribute("str","Java Web");
  //获得page 范围属性
  String str1 = (String) pageContext.getAttribute("str",PageContext.PAGE_SCOPE);
  //获得request 范围属性
  String str2 = (String) pageContext.getAttribute("str",PageContext.REQUEST_SCOPE);
%>
<%="page范围："+str1 %> <br />
<%="request范围："+str2 %><br />
</body>
</html>
