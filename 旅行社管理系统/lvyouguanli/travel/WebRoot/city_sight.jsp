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
	<h1 align="center"><font color="#288900" style="font-family: 黑体;font-size: 30px">城市景点信息</font></h1><br/>
	<c:if test="${empty sightList}">
		<table border="0" align="center"><tr><td><font color="#991188">没有找到要找的景点，请确认检索信息是否正确。</font></td></tr></table>
	</c:if>
	<c:forEach items="${sightList}" var="v">
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
								<c:if test="${v.discount == 100}">
									<font color="green">暂无打折</font><br/>
								</c:if>
								<c:if test="${v.discount != 100}">
									${v.discount/10 }折<br/>
								</c:if>
							</td>
						</tr>
						<tr>
							<td align="center">景点信息：</td><td><a href="indexsight.do?id=${v.id }">${v.info}</a></td>
						</tr>
		</table></td></tr></table>
	</c:forEach>
</body>
</html>