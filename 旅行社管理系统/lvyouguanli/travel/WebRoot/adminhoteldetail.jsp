<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>

<style>
  table td {line-height:30px;}
</style>

</head>
<body>
	<%@ include file="admin_logo.jsp" %>
	<form action="modifyhotelensure.do?id=${hotel.id }" method="post">
		<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
			<tr>
				<td width="10%">�Ƶ����ƣ�</td>
				<td width="80%">${hotel.name }</td>
			</tr>
			<tr>
				<td>���ڳ��У�</td>
				<td>${hotel.city }</td>
			</tr>
			<tr>
				<td>�Ƶ����ͣ�</td>
				<td>${hotel.star }</td>
			</tr>
			<tr>
				<td>�Ƶ���Ϣ��</td>
				<td>
					${hotel.info }
				</td>
			</tr>
			<tr>
				<td colspan="2"><a href="adminlistroom.do?id=${hotel.id }">���¾Ƶ귿����Ϣ</a></td>
			</tr>
			<tr><td height="5"></td></tr>
			<tr><td style="text-align:right;" colspan="2"><input  style="width:100px;" type="button" onclick="javascript:history.back();" value ="����"></td></tr>
		</table>
	</form>
</body>
</html>