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
	<h1 align="center">������Ϣ</h1><br/>
	<br/>
	<table align="center" width="900">
		<tr>
			<td><img src="img/default_pic.gif"/></td>
			<td align="left" width="700">
				<table border="0" width="700" height="250">
					<tr>
						<td align="center">������Ϣ��</td><td>${plane.number }</td>
					</tr>
					<tr>
						<td width="20%" align="center">�������У�</td><td width="80%" align="left">${plane.fromcity }</td>
					</tr>
					<tr>
						<td width="20%" align="center">Ŀ�ĳ��У�</td><td width="80%" align="left">${plane.destination }</td>
					</tr>
					<tr>
						<td align="center">���ʱ�䣺</td><td>${plane.fly_time }</td>
					</tr>
					<tr>
						<td align="center">����ʱ�䣺</td><td>${plane.arrive_time }</td>
					</tr>
					<tr>
						<td align="center">��Ʊ�۸�</td><td>${plane.fee }</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table>
		<tr><td><a href="reserveplane.do?id=${plane.id }">Ԥ������ </a></td></tr>
	</table>
</body>
</html>