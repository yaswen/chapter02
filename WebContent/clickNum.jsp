<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点击次数统计</title>
</head>
<body>
	<form action="clicknum" method="post">
		<input type="submit" value="点击"/>
	
	</form>
	
	点击按钮，已经点击了${empty applicationScope.num?0:applicationScope.num}次
</body>
</html>