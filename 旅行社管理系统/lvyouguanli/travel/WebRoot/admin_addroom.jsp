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
	<form action="roomadd.do?id=<%=request.getParameter("id")%>" method="post">
		<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
			<tr>
				<td width="10%">�������ͣ�</td>
				<td width="90%" align="left">
					<select name="type">
						<option value="���˷�">���˷�</option>
						<option value="˫�˷�">˫�˷�</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>����ţ�&nbsp;</td><td><input type="text" name="room"/></td>
			</tr>
			<tr>
				<td>������ã�</td><td><input type="text" name="cost"/></td>
			</tr>
			<tr>
				<td>�Ƿ�Ԥ��:</td><td><input type="text" name="reserved" value="0" readonly="readonly"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="ȷ��"/></td>
			</tr>
		</table>
	</form>
</body>
</html>