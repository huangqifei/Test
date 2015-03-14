<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<script type="text/javascript">
	function alt1() {
		alert("酒店暂时没有可预订的房间");
	}
</script>
</head>
<body>
	<%@ include file="logo.jsp" %>
	<table align="center" width="900">
		<tr>
			<td valign="top"><img src="img/default_pic.gif"/></td>
			<td align="left" width="700">
				<form action="fillhotelinfo.do?id=${hotel.id }" method="post" name="form1">
					<table border="0" width="700" height="250">
						<tr height="31">
							<td width="20%">&nbsp;&nbsp;酒店名称：</td><td width="30%">${hotel.name }</td>
							<td width="20%">客房类型：</td>
							<td>
								<a href="queryroomtype.do?id=${hotel.id }&type=1">单人房</a>
								<a href="queryroomtype.do?id=${hotel.id }&type=2">双人房</a>
							</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;酒店类型：</td><td>${hotel.star }</td>
							<td>酒店房号：</td>
							<c:if test="${!empty queryList}">
								<td>
									<select name="room">
										<c:forEach items="${queryList}" var="v">
											<option value="${v.room}">${v.room}</option>
											<c:if test="${!empty cost}">
												${cost}
											</c:if>
										</c:forEach>
									</select>
								</td>
							</c:if>
							<c:if test="${empty queryList}">
								<td>酒店暂时没有可预订的房间</td>
							</c:if>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;所在城市：</td><td>${hotel.city }</td>
							<td>入住时间：</td>
							<td>
								<input type="text" name="year" value="${year }" size="4"/>年
								<input type="text" name="month" value="${month }" size="4"/>月
								<input type="text" name="day" value="${day + 1 }" size="4"/>日
							</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;真实姓名：</td><td>${user.name }</td>
							<td>入住天数：</td>
							<td>
								<select name="live_day">
									<c:forEach begin="1" end="10" step="1" varStatus="vs">
										<option value="${vs.count}">${vs.count}</option>
									</c:forEach>
								</select>天
							</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;联系电话：</td><td>${user.telephone }</td>
						</tr>
						<tr height="32">
							<c:choose>
								<c:when test="${!empty queryList}">
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
				</form> 
			</td>
		</tr>
	</table>
</body>
</html>