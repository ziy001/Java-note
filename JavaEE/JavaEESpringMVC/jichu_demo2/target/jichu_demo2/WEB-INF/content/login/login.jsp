<%--
  Created by IntelliJ IDEA.
  User: ziy
  Date: 2020/11/26
  Time: 上午11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="accountLogin" method="POST">
    <tr>
        <td><spring:message code="name_label"/></td>
        <td>
            <input type="text" value="<spring:message code="name_hint"/>"/>
        </td>
    </tr>
    <tr>
        <td><spring:message code="password_label"/></td>
        <td>
            <input type="password" value="<spring:message code="password_hint"/>"/>
        </td>
    </tr>
</form>
</body>
</html>
