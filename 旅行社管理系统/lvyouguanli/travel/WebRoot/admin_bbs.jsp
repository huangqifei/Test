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
	<h4 align="center">BBS管理</h4>
	<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
		<c:forEach items="${bbsList}" var="v">
			<tr>
				<td width="800" align="left">&nbsp;&nbsp;&nbsp;&nbsp;${v.name }</td>
				<td width="100" align="center">
					<a href="adminbbsdelete.do?id=${v.id }">删除</a>
					<a href="adminseereply.do?id=${v.id}">跟帖管理</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>