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
	<form action="addsight.do" method="post">
		<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
			<tr>
				<td width="10%">景点名称：</td>
				<td width="80%"><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>所在城市：</td>
				<td><input type="text" name="city"/></td>
			</tr>
			<tr>
				<td>景点门票：</td>
				<td><input type="text" name="ticket_cost" /></td>
			</tr>
			<tr>
				<td>门票折扣：</td>
				<td><input type="text" name="discount"/></td>
			</tr>
			<tr>
				<td>景点信息：</td>
				<td>
					<textarea rows="10" cols="40" name="info" style="font-family: 黑体"></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="确定"/></td>
				<td align="left"><input type="reset" value="重写"/></td>
			</tr>
		</table>
	</form>
</body>
</html>