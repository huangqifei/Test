<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<% request.setCharacterEncoding("gb2312"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="logo.jsp" %>
	<h1 align="center">酒店信息</h1>
	<table align="center" width="900">
		<tr>
			<td><img src="img/default_pic.gif"/></td>
			<td align="left" width="700">
				<table border="0" width="700" height="250">
					<tr>
						<td>酒店名称：</td><td>${hotel.name }</td>
					</tr>
					<tr>
						<td width="20%">所在城市：</td><td width="80%" align="left">${hotel.city}</td>
					</tr>
					<tr>
						<td>酒店等级：</td><td>${hotel.star }</td>
					</tr>
					<tr>
						<td colspan="2" align="left"><a href="reservehotel.do?id=${hotel.id }">预订酒店</a></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center" style="font-family: 黑体 ;font-size: 20px" colspan="2">酒店信息：</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${hotel.info==null }"><font color="red">暂无信息</font></c:if>
				<c:if test="${hotel.info!=null }">${hotel.info }</c:if>
			</td>
		</tr>
		<tr><td colspan="2" align="center" height="50"></td></tr>
	</table>
</body>
</html>