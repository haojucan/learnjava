<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: axu
  Date: 2022/8/4
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>你好，欢迎进入首页，当前访问时间是：</h1>
<%
    out.println(new java.util.Date());

%>
</body>
</html>
