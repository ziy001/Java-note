<%@ page import="ziy.el2" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: vi193
  Date: 2020/8/11
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用EL表达式简化获取值的代码</title>
</head>
<body>
<%
    request.setAttribute("name", "李四");
    application.setAttribute("name", "王五");

    el2 a = new el2();
    a.setName("赵六");
    a.setAge(19);
    a.setDay(new Date());
    pageContext.setAttribute("a", a);
%>
普通获取<br>
<%=request.getAttribute("name")%>
<hr>
EL表达式获取<br>
${requestScope.name}
<br>
${applicationScope.name}
<br>
${name}
<hr>
${a["name"]}
${}


<br>


</body>
</html>
