<%--
  Created by IntelliJ IDEA.
  User: zhaoxuekai
  Date: 2021/8/13
  @Create: 2021-08-13 11:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/stu?action=login" method="post" autocomplete="off">
    登录名：<input type="text" name="loginname" required/><span style="color: red;">${requestScope.errorMsg}</span><br>
    密码：&nbsp;&nbsp;<input type="password" name="password" required/><br>
    <button type="submit">登录</button>
    <a href="${pageContext.servletContext.contextPath}/stu?action=toRegist">新用户注册</a>
</form>
</body>
</html>
