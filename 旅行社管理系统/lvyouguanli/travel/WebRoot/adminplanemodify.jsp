<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="admin_logo.jsp" %>
	<form action="modifyplaneensure.do?id=${plane.id }" method="post">
		<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
			<tr>
				<td width="10%">航班号：</td>
				<td width="80%"><input type="text" value="${plane.number }" name="number"/></td>
			</tr>
			<tr>
				<td>出发城市：</td>
				<td><input type="text" value="${plane.fromcity }" name="fromcity"/></td>
			</tr>
			<tr>
				<td>目的城市：</td>
				<td><input type="text" value="${plane.destination }" name="destination"/></td>
			</tr>
			<tr>
				<td>出发时间：</td>
				<td><input type="text" value="${plane.fly_time }" name="fly_time"/>请以yyyy.MM.dd hh:mm:ss格式填写</td>
			</tr>
			<tr>
				<td>到达时间：</td>
				<td><input type="text" value="${plane.arrive_time }" name="arrive_time"/>请以yyyy.MM.dd hh:mm:ss格式填写</td>
			</tr>
			<tr>
				<td>机票价格：</td>
				<td><input type="text" value="${plane.fee }" name="fee"/></td>
			</tr>
			<tr>
				<td>己有人数：</td>
				<td><input type="text" value="${plane.haspeople }" name="haspeople"/></td>
			</tr>
			<tr>
				<td>最大人数：</td>
				<td><input type="text" value="${plane.maxpeople }" name="maxpeople"/></td>
			</tr>
			<tr><td height="5"></td></tr>
			<tr>
				<td><input type="submit" value="确定"/></td>
				<td align="left"><a href="adminplanemodify.do?id=${plane.id}">重新填写</a></td>
			</tr>
		</table>
	</form>
</body>
</html>