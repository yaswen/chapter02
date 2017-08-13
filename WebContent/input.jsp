<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息采集~</title>
</head>
<body>
	 
	<form method="post" action="qiuzhouxin/user">
		用户名：<input type = "text" name = "userName"/><br/>
		地址：<input type = "text" name = "address"/><br/>
		电话：<input type = "text" name = "telephone"/><br/>
		邮箱：<input type = "text" name = "email"/><br/>
		<input type = "submit" value = "提交"/>
	</form>
	<!--
	<div>  
		
	</div>
	<div align="center">
		<s:form action="user">
			<s:textfield name="userName" key="用户名" />
			<s:textfield name="address" key="地址" />
			<s:textfield name="telephone" key="电话名" />
			<s:textfield name="email" key="邮箱" />
			<s:submit key="提交" value="提交" />
		</s:form>
	</div>
	 -->
</body>
</html>