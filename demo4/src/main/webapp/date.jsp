<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: axu
  Date: 2022/8/3
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% o response.getWriter().print(new Date().toLocaleString());%>
</body>
</html>
