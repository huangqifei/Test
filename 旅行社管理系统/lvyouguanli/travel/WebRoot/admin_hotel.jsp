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
	<h4 align="center">�Ƶ����</h4>
	<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
		<c:forEach items="${hotel}" var="v">
			<tr>
				<td width="20%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;${v.name }</td>
				<td width="90%" align="center">
					<a href="adminhotelmodify.do?id=${v.id }">�޸���Ϣ</a>
					&nbsp;&nbsp;<a href="adminhoteldelete.do?id=${v.id }">ɾ��</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2" align="center">
				<a href="admin_addhotel.jsp">���ӾƵ�</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</body>
</html>