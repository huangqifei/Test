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
	<form action="modifysightensure.do?id=${sight.id }" method="post">
		<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
			<tr>
				<td width="10%">景点名称：</td>
				<td width="80%"><input type="text" value="${sight.name }" name="name"/></td>
			</tr>
			<tr>
				<td>所在城市：</td>
				<td><input type="text" value="${sight.city }" name="city"/></td>
			</tr>
			<tr>
				<td>景点门票：</td>
				<td><input type="text" value="${sight.ticket_cost }" name="ticket_cost" /></td>
			</tr>
			<tr>
				<td>门票折扣：</td>
				<td><input type="text" value="${sight.discount }" name="discount"/></td>
			</tr>
			<tr>
				<td>景点信息：</td>
				<td>
					<textarea rows="10" cols="40" name="info" style="font-family: 黑体">${sight.info }</textarea>
				</td>
			</tr>
			<tr>
				<td>旅游团名：</td>
				<td>
					<c:choose>
						<c:when test="${empty groupList}">
							暂时没有去该景点的旅游团
						</c:when>
						<c:otherwise>
							<c:forEach items="${groupList}" var="v">
								<a href="">${v.name }</a>&nbsp;&nbsp;<a href="">删除</a><br/>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="确定"/></td>
				<td align="left"><a href="adminsightmodify.do?id=${sight.id}">重新填写</a></td>
			</tr>
		</table>
	</form>
</body>
</html>