<%--
  Created by IntelliJ IDEA.
  User: axu
  Date: 2022/8/15
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login Successfully</title>
    <style>
        #main {
            width: 500px;
            height: auto;
        }

        #main div {
            width: 200px;
            height: auto;
        }

        ul {
            padding-top: 1px;
            padding-left: 1px;
            list-style: none;
        }
    </style>
</head>
<body>
        <%
            if (session.getAttribute("userBean") == null) {
        %>
        <jsp:forward page="register.jsp" />
        <%
                return;
            }
        %>
<div id="main">
    <div id="welcome">恭喜你，登录成功</div>
    <hr/>
    <div>您的信息</div>
    <div>
        <ul>
            <li>您的姓名：${userBean.name}</li>
            <li>您的密码是：${userBean.password}</li>
        </ul>
    </div>
</div>
</body>
</html>
