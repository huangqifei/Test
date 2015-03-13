<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="admin_logo.jsp" %>
	<h4 align="center">航班管理</h4>
	<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
		<tr><td width="20%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;航班号</td><td width="90%" align="center">管理员操作</td></tr>
		<tr><td colspan="2" bgcolor="green" height="1"></td></tr>
		<c:forEach items="${plane}" var="v">
			<tr>
				<td width="20%" align="left">${v.number }</td>
				<td width="90%" align="center">
					<a href="adminplanemodify.do?id=${v.id }">修改信息</a>&nbsp;&nbsp;
					<a href="adminplanedelete.do?id=${v.id }">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2" align="center">
				<a href="admin_addplane.jsp">添加航班</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</body>
</html>