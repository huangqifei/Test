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
	<form action="register.do" method="post" name="form1">
		<table align="center" border="0" width="900">
			<tr>
				<td align="right">�û�����</td>
				<td align="left">
					<input type="name" name="name" value="${user.name }"/>${exist}
				</td>
			</tr>
			<tr align="right">
				<td>���룺</td><td align="left"><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td align="right">��ʵ������</td><td><input type="text" name="tname" value="${user.tname }"/></td>
			</tr>
			<tr>
				<td align="right">��ϵ�绰��</td><td><input type="text" name="telephone" value="${user.telephone }"/></td>
			</tr>
			<tr>
				<td align="right">&nbsp;<input type="submit" value="ȷ��"/>&nbsp;&nbsp;</td>
				<td align="left"><input type="reset" value="����"/></td>
			</tr>
		</table>
	</form>
</body>
</html>