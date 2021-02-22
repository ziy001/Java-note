<%--
  Created by IntelliJ IDEA.
  User: ziy
  Date: 2020/11/16
  Time: 上午11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h3>登录成功</h3>
    <br/>
    <h3>${tip}</h3>
    <hr/>
    <h3>${requestScope.message}</h3>
    <h3>现在时间: ${requestScope.now}</h3>
    <hr/>
    <a href="${pageContext.request.contextPath}/books.json">book.json</a>
    <a href="${pageContext.request.contextPath}/books">book</a>
</body>
</html>
