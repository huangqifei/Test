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
	<table border="0" width="900" align="center" >
		<tr><td>
			<hr/>
			<form action="querysight.do" method="post">
				城市名：<input type="text" name="city" size="15"/>&nbsp;&nbsp;
				景点名：<input type="text" name="name" size="15"/>&nbsp;&nbsp;
				<input type="submit" value="查询"/>
			</form>
		</td></tr>
	</table>
	<c:forEach items="${sight}" var="v">
		<p/>
		<table align="center" width="700">
			<tr>
				<td><img src="img/default_pic_small.gif"/></td>
				<td align="left" width="500">
					<table border="0" width="500" height="120">
						<tr>
							<td width="25%" align="center">景点名称：</td>
							<td width="75%" align="left"><a href="indexsight.do?id=${v.id }">${v.name}</a></td>
						</tr>
						<tr>
							<td align="center">景点门票：</td><td>${v.ticket_cost }</td>
						</tr>
						<tr>
							<td align="center">门票折扣：</td>
							<td>
								<c:if test="${v.discount == 10}">
									<font color="green">暂无打折</font><br/>
								</c:if>
								<c:if test="${v.discount != 10}">
									${v.discount }折<br/>
								</c:if>
							</td>
						</tr>
						<tr>
							<td align="center">景点信息：</td>
							<td>
								<a href="indexsight.do?id=${v.id }"><font color="black">${v.info}</font></a>
							</td>
						</tr>
		</table></td></tr></table>
	</c:forEach>
</body>
</html>