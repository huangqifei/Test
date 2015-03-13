<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>

<style>
  table td {line-height:30px;}

</style>
</head>
<body>
	<%@ include file="admin_logo.jsp" %>
	<form action="modifysightensure.do?id=${sight.id }" method="post">
		<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
			<tr>
				<td width="10%">景点名称：</td>
				<td width="80%">${sight.name }</td>
			</tr>
			<tr>
				<td>所在城市：</td>
				<td>${sight.city }</td>
			</tr>
			<tr>
				<td>景点门票：</td>
				<td>${sight.ticket_cost } 元</td>
			</tr>
			<tr>
				<td>门票折扣：</td>
				<td>${sight.discount } 折</td>
			</tr>
			<tr>
				<td style="vertical-align:top;">景点信息：</td>
				<td>
					${sight.info }
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
			<tr><td style="text-align:right;" colspan="2"><input  style="width:100px;" type="button" onclick="javascript:history.back();" value ="返回"></td></tr>
		</table>
	</form>
</body>
</html>