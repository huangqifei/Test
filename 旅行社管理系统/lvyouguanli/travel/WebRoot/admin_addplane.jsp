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
	<form action="addplane.do" method="post">
		<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
			<tr>
				<td width="10%">&nbsp;&nbsp;航班号：</td>
				<td width="80%"><input type="text" name="number"/></td>
			</tr>
			<tr>
				<td>出发城市：</td>
				<td><input type="text" name="fromcity"/></td>
			</tr>
			<tr>
				<td>目的城市：</td>
				<td><input type="text" name="destination"/></td>
			</tr>
			<tr>
				<td>出发时间：</td>
				<td><input type="text" name="fly_time"/>请以yyyy.MM.dd hh:mm:ss格式填写</td>
			</tr>
			<tr>
				<td>到达时间：</td>
				<td><input type="text" name="arrive_time"/>请以yyyy.MM.dd hh:mm:ss格式填写</td>
			</tr>
			<tr>
				<td>己有人数：</td>
				<td><input type="text" name="haspeople" /></td>
			</tr>
			<tr>
				<td>最大人数：</td>
				<td><input type="text" name="maxpeople" /></td>
			</tr>
			<tr>
				<td>机票价格：</td>
				<td><input type="text" name="fee" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="确定"/></td>
				<td align="left"><input type="reset" value="重写"/></td>
			</tr>
		</table>
	</form>
</body>
</html>