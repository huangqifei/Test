<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">�û���½</h1>
	<hr/>
	<form action="login.do" method="post" name="form1">
		<table align="center" border="0" cellpadding="0" cellspacing="0" width="200" height="100">
			<tr>
				<td>�û�����</td><td align="left"><input type="text" name="name" size="15"/></td>
			</tr>
			<tr>
				<td>��&nbsp;�룺</td><td align="left"><input type="password" name="password" size="15"/></td>
			</tr>
			<tr>
				<td align="right"><input type="button"  value="��¼" onclick="form1.submit()"/>&nbsp;</td>
				<td align="left">&nbsp;<input type="button" value="����" onclick="form1.reset()"/></td>
			</tr>
		</table>
	</form>
</body>
</html>