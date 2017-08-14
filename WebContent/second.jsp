<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户信息</title>
</head>
<body>
<div align="center">
请求中的用户信息：${param.userName}！<br/>
Session中的用户信息：${session.CurUser}<br/>
<a href="first.jsp">上一页</a>
</div>
</body>
</html>