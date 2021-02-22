<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author yeeku.H.lee kongyeeku@163.com 公众号: fkbooks
version 1.0
Copyright (C), 2001-2020, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div class="container">
<h4>添加图书</h4>
	<form action="/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /><br /><br />
		<input type="submit" value="上传" />
	</form>
</div>
</body>
</html>