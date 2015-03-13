<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<script type="text/javascript">
	function alt1() {
		alert("旅游团人数已满");
	}
</script>

</head>
<body>
	<%@ include file="logo.jsp" %>
	<form action="fillgroupinfo.do?id=${group.id }" method="post" name="form1">
		<table align="center" width="900">
			<tr>
				<td valign="top"><img src="img/default_pic.gif"/></td>
				<td align="left" width="700">
					<table border="0" width="700" height="250">
						<tr height="31">
							<td width="20%">&nbsp;&nbsp;旅游团名：</td>
							<td width="30%">${group.name }</td>
							<td width="20%">总人数：</td>
							<td width="30%">${group.maxpeople }</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;景点名称：</td>
							<td>${sight.name }</td>
							<td>已有人数</td>
							<td>${group.haspeople }</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;支付费用：</td><td>${group.cost }</td>
							<td>预订人数：</td>
							<td>
								<c:set value="${group.maxpeople - group.haspeople}" var="p"/>
								<c:choose>
									<c:when test="${p != 0}">
										<select name="reservepeople">
											<c:forEach begin="1" end="${p}" step="1" varStatus="vs">
												<option value="${vs.count}">${vs.count}</option>
											</c:forEach>
										</select>
									</c:when>
									<c:otherwise>
										<font color="#9911cc">本旅游团已经满</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;旅游团信息：</td>
							<td>
								<c:if test="${empty groupinfo }">暂时没有该旅游团的信息</c:if>
								<c:if test="${!empty groupinfo }">${group.info }</c:if>
							</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;真实姓名：</td><td>${user.name }</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;联系电话：</td><td>${user.telephone }</td>
						</tr>
						<tr height="31">
							<td></td>
						</tr>
						<tr height="40">
							<c:choose>
								<c:when test="${p != 0}">
									<td>
										&nbsp;&nbsp;&nbsp;<img src="img/dr.gif" onclick="form1.submit()"/>
									</td>
									<td>
										&nbsp;&nbsp;&nbsp;<a href="modify_info.jsp"><img src="img/modifyuserinfo.gif"/></a>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										&nbsp;&nbsp;&nbsp;<img src="img/dr.gif" onclick="alt1()"/>
									</td>
									<td>
										&nbsp;&nbsp;&nbsp;<a href="modify_info.jsp"><img src="img/modifyuserinfo.gif"/></a>
									</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>