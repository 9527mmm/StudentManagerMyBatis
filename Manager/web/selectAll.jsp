<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhaoxuekai
  Date: 2021/8/13
  @Create: 2021-08-13 12:55
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>
    table {
        border-collapse: collapse
    }
</style>
<head>
    <title>查询全部</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/stu?action=conditions" method="post">
    姓名：<input type="text" name="name">
    成绩：<input type="text" name="score"><br>
    <button type="submit">查找</button>
    <br>
    <a href="index.jsp">返回主页</a>
    <hr>
</form>
<table border="1" collapse="0">
    <tr>
        <th>编号</th>
        <th>学生姓名</th>
        <th>学生年龄</th>
        <th>学生性别</th>
        <th>学生成绩</th>
        <th>学生生日</th>
        <th>删除</th>
        <th>修改</th>
    </tr>
    <c:forEach var="studnt" varStatus="status" items="${requestScope.studentList}">
        <tr>
            <td>${status.count}</td>
            <td>${studnt.name}</td>
            <td>${studnt.age}</td>
            <td>${studnt.gender}</td>
            <td>${studnt.score}</td>
            <td>${studnt.birStr}</td>
            <td>
                <button id="del"><a onclick="drop()"
                                    href="${pageContext.servletContext.contextPath}/stu?action=delete&id=${studnt.id}">删除</a>
                </button>
            </td>
            <td><a href="${pageContext.servletContext.contextPath}/stu?action=toUpdate&id=${studnt.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
<script>
    document.getElementById("del").onclick = function () {
        alert("删除成功");
    }

    function drop() {
        alert("删除成功");
    }
</script>
</html>
