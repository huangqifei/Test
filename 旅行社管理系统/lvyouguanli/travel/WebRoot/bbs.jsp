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
	<table border="0" cellpadding="0" cellspacing="8" width="900" align="center">
		<tr>
			<td width="900" colspan="4">[<a href="mypost.jsp">发表帖子</a>] </td>
		</tr>
			<tr>
				<td width="20%" align="left">标题</td>
				<td width="40%">内容</td>
				<td width="12%">发表日期</td>
				<td width="10%">访问人数</td>
				<td width="10%">回复人数</td>
			</tr>
	    <c:forEach items="${bbsList}" var="v">
			<tr>
				<td width="20%" align="left">
					<a href="seeposts.do?id=${v.id}">${v.name}</a>
				</td>
				<td width="40%">${v.content}</td>
				<td width="12%">${v.date}</td>
				<td width="10%">${v.access}</td>
				<td width="10%">${v.reply}</td>
			</tr>
		</c:forEach>
				<!--  -->
	</table>
</body>
</html>