<%--
  Created by IntelliJ IDEA.
  User: axu
  Date: 2022/8/23
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <style type="text/css">
        h3 {
            margin-left: 100px;
        }

        #outer {
            width: 750px;
        }

        span {
            color: #ff8c00;
        }

        div {
            height: 20px;
            margin-bottom: 10px;
        }

        .ch {
            width: 80px;
            text-align: right;
            float: left;
        }

        .ip {
            width: 500px;
            float: left;
        }

        .ip > input {
            margin-left: 20px;
        }

        #bt {
            margin-left: 50px;
        }

        #bt > input {
            margin-right: 30px;
        }
    </style>
</head>
<body>
<form action="ControllerServlet" method="post">
    <h3>用户注册</h3>
    <div id="outer">

        <div>
            <div class="ch"> 姓名：</div>
            <div class="ip">
                <label>
                    <input type="text" name="name" value="${formBean.name}"/>
                </label>
                <span>${formBean.errors.name} ${DBMes}</span>
            </div>
        </div>
    </div>
    <div>
        <div class="ch"> 密码：</div>
        <div class="ip">
            <label>
                <input type="text" name="password"/>
            </label>
            <span>${formBean.errors.password}</span>
        </div>
    </div>
    <div>
        <div class="ch"> 确认密码：</div>
        <div class="ip">
            <label>
                <input type="text" name="password2"/>
            </label>
            <span>${formBean.errors.password2}</span>
        </div>
    </div>
    <div>
        <div class="ch"> 邮箱：</div>
        <div class="ip">
            <label>
                <input type="text" name="email" value="${formBean.email}"/>
            </label>
            <span>${formBean.errors.email}</span>
        </div>
    </div>

    <div class="bt">
        <label>
            <input type="reset" value="重置"/>
        </label>
        <label>
            <input type="submit" value="注册"/>
        </label>

    </div>


</form>
</body>
</html>
