<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>

<style type="text/css">
	table td {line-height:30px;}
	
</style>
</head>
<body>
	<%@ include file="admin_logo.jsp" %>
	<form action="modifyplaneensure.do?id=${plane.id }" method="post">
		<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
			<tr>
				<td width="10%">����ţ�</td>
				<td width="80%">${plane.number }</td>
			</tr>
			<tr>
				<td>�������У�</td>
				<td>${plane.fromcity }</td>
			</tr>
			<tr>
				<td>Ŀ�ĳ��У�</td>
				<td>${plane.destination }</td>
			</tr>
			<tr>
				<td>����ʱ�䣺</td>
				<td>${plane.fly_time } </td>
			</tr>
			<tr>
				<td>����ʱ�䣺</td>
				<td>${plane.arrive_time } </td>
			</tr>
			<tr>
				<td>��Ʊ�۸�</td>
				<td>${plane.fee }</td>
			</tr>
			<tr>
				<td>����������</td>
				<td>${plane.haspeople }</td>
			</tr>
			<tr>
				<td>���������</td>
				<td>${plane.maxpeople }</td>
			</tr>
			<tr><td height="5"></td></tr>
			<tr>
				<td><a href="javascript:history.back();"></a></td>
			</tr>
		</table>
	</form>
</body>
</html>