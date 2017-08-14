<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>include</title>
</head>
<body>
	<h1 align="center">包含</h1>
	<div align="center">
	<s:set name="score" value="78"/>
	分数是：<s:property value="#score"/>
	<s:include value="login.jsp"></s:include>
	</div>
	<div>
		<s:include value="productList.jsp"></s:include>
		<s:include value="second.jsp"></s:include>
	</div>
</body>
</html>