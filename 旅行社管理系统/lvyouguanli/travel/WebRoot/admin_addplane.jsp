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
				<td width="10%">&nbsp;&nbsp;����ţ�</td>
				<td width="80%"><input type="text" name="number"/></td>
			</tr>
			<tr>
				<td>�������У�</td>
				<td><input type="text" name="fromcity"/></td>
			</tr>
			<tr>
				<td>Ŀ�ĳ��У�</td>
				<td><input type="text" name="destination"/></td>
			</tr>
			<tr>
				<td>����ʱ�䣺</td>
				<td><input type="text" name="fly_time"/>����yyyy.MM.dd hh:mm:ss��ʽ��д</td>
			</tr>
			<tr>
				<td>����ʱ�䣺</td>
				<td><input type="text" name="arrive_time"/>����yyyy.MM.dd hh:mm:ss��ʽ��д</td>
			</tr>
			<tr>
				<td>����������</td>
				<td><input type="text" name="haspeople" /></td>
			</tr>
			<tr>
				<td>���������</td>
				<td><input type="text" name="maxpeople" /></td>
			</tr>
			<tr>
				<td>��Ʊ�۸�</td>
				<td><input type="text" name="fee" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="ȷ��"/></td>
				<td align="left"><input type="reset" value="��д"/></td>
			</tr>
		</table>
	</form>
</body>
</html>