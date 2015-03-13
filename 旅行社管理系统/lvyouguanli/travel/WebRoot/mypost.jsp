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
	<form action="apearpost.do" method="post">
		<table border="0" cellpadding="0" cellspacing="9" width="900" align="center">
			<tr>
				<td width="20%" align="center">标题</td>
				<td width="80%" align="left">
					<input type="text" name="name" size="60"/>
				</td>
			</tr>
			<tr>
				<td width="20%" align="center">内容</td>
				<td width="80%" align="left">
					<textarea rows="10" cols="90" name="content" style="font-family: 宋体;font-size: 14px"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="确定"/></td>
			</tr>
		</table>
	</form>
</body>
</html>