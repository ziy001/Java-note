<%--
  Created by IntelliJ IDEA.
  User: vi193
  Date: 2020/8/21
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  index.jsp...
  <%
    String encode;
    if(response.getCharacterEncoding().equals("UTF-8")) {
      encode = response.getCharacterEncoding();
      response.setCharacterEncoding("GB2312");
    }
    else {
      encode = response.getCharacterEncoding();
    }
    System.out.println("当前编码: "+ encode);
  %>
  <hr>
  </body>
</html>
