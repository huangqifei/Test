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
		<tr>
			<td>
				<c:choose>
					<c:when test="${empty reply}">
					</c:when>
					<c:otherwise>
						<c:forEach items="${reply}" var="v">
							<tr>
								<td align="center" width="80%">
									${v.rid}楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[作者]：${v.uname }&nbsp;&nbsp;
									<a href="replydelete.do?id=${v.rid}">删除</a>
								</td>
							</tr>
							<tr>
								<td bgcolor="#9edff7">${v.content}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</body>
</html>