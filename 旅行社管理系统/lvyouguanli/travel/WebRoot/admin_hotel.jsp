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
	<h4 align="center">酒店管理</h4>
	<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
	
	<tr><td  width="30%">酒店名称 </td>  <td width="20%" align="center">操作</td></tr>
		<c:forEach items="${hotel}" var="v">
			<tr>
				<td width="30%" align="left">${v.name }</td>
				<td width="20%" align="center">
				    <a href="adminhoteldetail.do?id=${v.id}">查看详情</a>
					<a href="adminhotelmodify.do?id=${v.id }">修改信息</a>
					&nbsp;&nbsp;<a href="adminhoteldelete.do?id=${v.id }">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2" align="center">
				<a href="admin_addhotel.jsp">添加酒店</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</body>
</html>