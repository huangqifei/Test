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
	<form action="addhotel.do" method="post">
		<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
			<tr>
				<td width="10%">�Ƶ����ƣ�</td>
				<td width="80%"><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>���ڳ��У�</td>
				<td><input type="text" name="city"/></td>
			</tr>
			<tr>
				<td>�Ƶ�����(�Ǽ�)��</td>
				<td><input type="text" name="star" /></td>
			</tr>
			<tr>
				<td>�Ƶ���Ϣ��</td>
				<td>
					<textarea rows="10" cols="40" name="info" style="font-family: ����"></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="ȷ��"/></td>
				<td align="left"><input type="reset" value="��д"/></td>
			</tr>
		</table>
	</form>
</body>
</html>