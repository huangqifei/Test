<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="logo.jsp" %>
	<h1 align="center">航班信息</h1><br/>
	<br/>
	<table align="center" width="900">
		<tr>
			<td><img src="img/default_pic.gif"/></td>
			<td align="left" width="700">
				<table border="0" width="700" height="250">
					<tr>
						<td align="center">航班信息：</td><td>${plane.number }</td>
					</tr>
					<tr>
						<td width="20%" align="center">出发城市：</td><td width="80%" align="left">${plane.fromcity }</td>
					</tr>
					<tr>
						<td width="20%" align="center">目的城市：</td><td width="80%" align="left">${plane.destination }</td>
					</tr>
					<tr>
						<td align="center">起飞时间：</td><td>${plane.fly_time }</td>
					</tr>
					<tr>
						<td align="center">到达时间：</td><td>${plane.arrive_time }</td>
					</tr>
					<tr>
						<td align="center">机票价格：</td><td>${plane.fee }</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table>
		<tr><td><a href="reserveplane.do?id=${plane.id }">预订航班 </a></td></tr>
	</table>
</body>
</html>