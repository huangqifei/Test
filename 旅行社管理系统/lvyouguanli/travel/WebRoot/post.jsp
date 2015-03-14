<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="logo.jsp" %>
	<table border="0" cellpadding="0" cellspacing="9" width="900" align="center">
		<tr>
			<td colspan="2" height="30" bgcolor="#4ba8b6" width="900" style="font-family: ����;font-size: 20px; color: white;" align="center">
				${post.name}
			</td>
		</tr>
		<tr>
			<td align="center">[����]��${userinfo.name }&nbsp;&nbsp;[��������]��${post.date }</td>
		</tr>
		<tr>
			<td bgcolor="#9edff7">${post.content }</td>
		</tr>
		
		<tr><td>�����������£�</td></tr>
		<c:choose>
			<c:when test="${empty replyList}">
			</c:when>
			<c:otherwise>
				<c:forEach items="${replyList}" var="v">
					<tr>
						<td align="center" width="80%">
							${v.rid}¥&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[����]��${v.username }&nbsp;&nbsp;[��������]��${v.date }
						</td>
					</tr>
					<tr>
						<td bgcolor="#9edff7">${v.content}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<form action="appearreply.do?id=${post.id }&rid=${fn:length(replyList)}" method="post">
		<table border="0" cellpadding="0" cellspacing="0" width="400" align="center">
			<tr>
				<td align="center">
					<textarea rows="7" cols="80" name="content" style="font-size: 15px;font-family: ����"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center">
					<c:if test="${empty user}"><a href="login.jsp">���ȵ�½�ٻ���</a></c:if>
					<c:if test="${!empty user}"><input type="submit" value="����"/></c:if>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>