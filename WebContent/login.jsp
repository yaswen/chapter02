<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<div align="center">
	<form action="login4" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="userName" size="15"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" size="15"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登录"></td>
			</tr>
		</table>
	</form>
	<s:fielderror/>
	<div>
	<s:if test="'zhao' in {'zhao','gao'}">
		在
	</s:if>
	<s:else>
		不在
	</s:else>
	</div>
</div>
</body>
</html>