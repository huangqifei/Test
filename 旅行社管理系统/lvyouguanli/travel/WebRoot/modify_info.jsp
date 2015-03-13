<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
	<h1>修改个人信息：</h1>
	<hr/>
	<form action="modifyuserinfo.do" method="post">
		<table border="0" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<td>用户名：</td><td><input type="text" name="name" value="${user.name }"/></td>
			</tr>
			<tr>
				<td>真实姓名：</td><td><input type="text" name="tname" value="${user.tname }"/></td>
			</tr>
			<tr>
				<td>联系电话：</td><td><input type="text" name="telephone" value="${user.telephone }"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="确定修改"/>&nbsp;&nbsp;<input type="reset" value="重新填写"/></td>
			</tr>
		</table>
	</form>
</body>
</html>