<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
	<h1>�޸ĸ�����Ϣ��</h1>
	<hr/>
	<form action="modifyuserinfo.do" method="post">
		<table border="0" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<td>�û�����</td><td><input type="text" name="name" value="${user.name }"/></td>
			</tr>
			<tr>
				<td>��ʵ������</td><td><input type="text" name="tname" value="${user.tname }"/></td>
			</tr>
			<tr>
				<td>��ϵ�绰��</td><td><input type="text" name="telephone" value="${user.telephone }"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="ȷ���޸�"/>&nbsp;&nbsp;<input type="reset" value="������д"/></td>
			</tr>
		</table>
	</form>
</body>
</html>