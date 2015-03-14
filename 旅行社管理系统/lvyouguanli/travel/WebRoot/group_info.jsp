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
	<table border="0" height="20"><tr><td></td></tr></table>
	<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
		<tr height="25">
			<td>
				旅游团名称：&nbsp;&nbsp;<c:out value="${group.name}"/>&nbsp;&nbsp;&nbsp;&nbsp;
				旅游团信息：&nbsp;&nbsp;
				<c:if test="${empty group.info}">该旅游团暂未注册信息</c:if>
				<c:if test="${!empty group.info}">${group.info}</c:if>
			</td>
		</tr>
		<tr height="25">
			<td>
				已有人数：&nbsp;&nbsp;${group.haspeople}&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;总人数：&nbsp;&nbsp;${group.maxpeople}
			</td>
		</tr>
		<tr height="25">
			<td>还去景点：&nbsp;&nbsp;
				<c:forEach items="${sightList}" var="v" varStatus="vs" >
					<a href="indexsight.do?id=${v.id }">${v.name}</a>
					<c:if test="${vs.count != fn:length(sightList)}">、</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr height="25">
			<td><a href="reservegroup.do?groupid=${group.id }&sightid=${sight.id }">预订旅游团</a></td>
		</tr>
	</table>
	

	
</body>
</html>