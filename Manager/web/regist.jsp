<%--
  Created by IntelliJ IDEA.
  User: zhaoxuekai
  Date: 2021/8/16
  @Create: 2021-08-16 22:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form method="post" id="regist" action="${pageContext.servletContext.contextPath}/stu?action=regist" class="login-form"
      autocomplete="off">
    <input type="hidden" name="uid" value="${requestScope.uid.substring(0,8)}"/>
    <input type="hidden" name="ucode" value="${requestScope.ucode}"/>
    <table border="1px" align="center">
        <tr>
            <th>登录名</th>
            <th>密码</th>
            <th>姓名</th>
            <th>性别</th>
            <th>生日</th>
            <th>入职日期</th>
        </tr>
        <tr>
            <td><input type="text" name="loginname" id="loginname" required/></td>
            <td><input type="password" name="password" id="password" required/></td>
            <td><input type="text" name="username" required/></td>
            <td><input type="radio" name="gender" value="man" checked/>男
                <input type="radio" name="gender" value="women"/>女
            </td>
            <td><input type="date" name="birthday" required/></td>
            <td><input type="date" name="dutydate" required/></td>
        </tr>
    </table>
    <button type="submit">提交</button>
</form>
</body>
<script src="js/my.js"></script>
</html>
