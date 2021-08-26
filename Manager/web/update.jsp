<%--
  Created by IntelliJ IDEA.
  User: zhaoxuekai
  Date: 2021/8/13
  @Create: 2021-08-13 12:56
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    table{
        border-collapse:collapse
    }
</style>
<head>
    <title>修改</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/stu?action=update" method="post">
    <input type="hidden" value="${requestScope.student.id}" name="id"/>
    <table border="1" collapse="0">
        <tr>
            <th>学生姓名</th>
            <th>学生年龄</th>
            <th>学生性别</th>
            <th>学生成绩</th>
            <th>学生生日</th>
        </tr>
        <tr>
            <th><input type="text" name="name" value="${requestScope.student.name}"></th>
            <th><input type="text" name="age" value="${requestScope.student.age}"></th>
            <th><input type="text" name="gender" value="${requestScope.student.gender}"></th>
            <th><input type="text" name="score" value="${requestScope.student.score}"></th>
            <th><input type="date" name="bir" value="${requestScope.student.birStr}"></th>
        </tr>
    </table>
    <button type="submit">修改</button>
</form>
</body>
</html>
