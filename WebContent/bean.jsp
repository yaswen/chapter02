<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bean</title>
</head>
<body>
	<s:bean name="com.ysw.chapter02.pojos.IdCard">
		<s:param name="id" value="2"/>
		<s:param name="cardNo" value="222"/>
		id:<s:property value="id"/><br/>
		No:<s:property value="cardNo"/><br/>
	</s:bean>
</body>
</html>