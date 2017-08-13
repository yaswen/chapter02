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
		用户信息采集成功：<br />
		用户名：${param.userName}<br />
		地址：${param.address}<br />
		电话：${param.telephone}<br />
		邮箱：${param.email}<br />
	</div>
</body>
</html>