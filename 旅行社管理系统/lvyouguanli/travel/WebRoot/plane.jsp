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
		<table border="0" width="900" align="center" >
		<tr><td>
			<hr/>
			<form action="queryplane.do" method="post">
				航班号：<input type="text" name="number" size="15"/>&nbsp;&nbsp;
				出发城市：<input type="text" name="fromcity" size="15"/>&nbsp;&nbsp;
				<input type="submit" value="查询"/>
			</form>
		</td></tr>
	</table>
		<c:forEach items="${planeList}" var="v">
		<p/>
		<table align="center" width="700">
			<tr>
				<td><img src="img/default_pic_small.gif"/></td>
				<td align="left" width="500">
					<table border="0" width="500" height="120">
						<tr>
							<td width="25%" align="center">航班号：</td>
							<td width="75%" align="left"><a href="indexplane.do?id=${v.id }">${v.number}</a></td>
						</tr>
						<tr>
							<td align="center">出发城市：</td><td>${v.fromcity }</td>
						</tr>
						<tr>
							<td align="center">目的城市：</td>
							<td>${v.destination}</td>
						</tr>
						<tr>
							<td align="center">起飞时间：</td><td>${v.fly_time}</td>
						</tr>
		</table></td></tr></table>
	</c:forEach>
</body>
</html>