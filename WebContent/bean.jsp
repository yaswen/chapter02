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
	<s:iterator var="num" begin="1" end="10" step="1">
		<s:property value="#num"/>
	</s:iterator>
	<div align="center">
	<table border=0 width=200>
		<s:iterator value="{'刘备','关羽','张飞','赵云','马超','诸葛亮'}" id="heroName" status="st">
			<tr <s:if test="#st.odd"> style="background-color:#def7c2" </s:if>>
				<td><s:property value="#st.count"/></td>
				<td><s:property value="heroName"/></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</body>
</html>