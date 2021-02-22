<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: vi193
  Date: 2020/8/12
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取List集合值和Map集合值</title>
</head>
<body>
<%
  ArrayList<String> list = new ArrayList<>();
  list.add("aaa");
  list.add("bbb");

  HashMap<String, Integer> map = new HashMap<>();
  map.put("one", 1);
  pageContext.setAttribute("map", map);
pageContext.setAttribute("list", list);
%>
${list[1]}<br>
${list[12]}<br>
测试<br>
${list.add(2, "1212")}<br>
${list[2]}<br>
<hr>
${map["one"]}<br>
${map.one}
</body>
</html>
