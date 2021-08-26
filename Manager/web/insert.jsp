<%--
  Created by IntelliJ IDEA.
  User: zhaoxuekai
  Date: 2021/8/13
  @Create: 2021-08-13 12:56
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    table {
        border-collapse: collapse
    }
</style>
<head>
    <title>添加</title>
</head>
<body>
<form onsubmit="sub()" action="${pageContext.servletContext.contextPath}/stu?action=insert" method="post">
    <input type="hidden" value="null" name="id"/>
    <table border="1" collapse="0">
        <tr>
            <th>学生姓名</th>
            <th>学生年龄</th>
            <th>学生性别</th>
            <th>学生成绩</th>
            <th>学生生日</th>
        </tr>
        <tr>
            <th><input type="text" name="name" required/></th>
            <th><input type="text" name="age" required/></th>
            <th><input type="text" name="gender" required/></th>
            <th><input type="text" name="score" required/></th>
            <th><input type="date" name="bir" required/></th>
        </tr>
    </table>
    <button type="submit">添加</button>
</form>
</body>
<script>
    function sub(){
        alert("提交成功");
    }
</script>
</html>
