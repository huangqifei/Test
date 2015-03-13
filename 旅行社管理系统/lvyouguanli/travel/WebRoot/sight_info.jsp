<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="logo.jsp" %>
	<h1 align="center"><font color="#288900" style="font-family: 黑体">景点信息</font></h1><br/>
	<table align="center" width="900">
		<tr>
			<td><img src="img/default_pic.gif"/></td>
			<td align="left" width="700">
				<table border="0" width="700" height="250">
					<tr>
						<td>景点名称：</td><td>${sight.name }</td>
					</tr>
					<tr>
						<td width="20%">所在城市：</td><td width="80%" align="left"><a href="indexcity.do?id=${sight.id }">${sight.city}</a></td>
					</tr>
					<tr>
						<td>旅游团信息：</td>
						<td>
							<c:choose>
								<c:when test="${empty group}">
									<font color="red">暂时没有旅游团去该景点</font>
								</c:when>
								<c:otherwise>
									<c:forEach items="${group}" var="v" varStatus="vs" >
										<a href="groupinfo.do?groupid=${v.id }&sightid=${sight.id}">${v.name }</a>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td>门票价格：</td><td>${sight.ticket_cost}</td>
					</tr>
					<tr>
						<td>门票折扣：</td><td>${sight.discount}</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center" style="font-family: 黑体 ;font-size: 20px" colspan="2">景点信息:</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${sight.info==null }"><font color="red">暂无景点信息</font></c:if>
				<c:if test="${sight.info!=null }">${sight.info}</c:if>
			</td>
		</tr>
	</table>
</body>
</html>