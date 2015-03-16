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
	<table border="0" align="center">
		<tr><td>
			<br/>
			<h1>用户个人信息</h1>
			<hr/>
			用户名:${user.name }<br/>
			真实姓名：${user.tname }<br/>
			联系电话：${user.telephone }<br/>
			邮箱：${user.email }<br/>
			<a href="modify_info.jsp">修改个人信息</a>
			<a href="welcome.do">返回首页</a>
			<li><font color="#3e44a1">预订酒店信息：</font></li><br/>
			<table border="0" cellpadding="0" bordercolor="blue">
				<c:choose>
					<c:when test="${empty hotelList}">
						<tr><td><font color="#339922">暂时还未预订任何酒店</font></td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${hotelList}" var="v" varStatus="vs">
							<c:if test="${vs.count%2==1}"><c:set value="#ffee99" var="c"/></c:if>
							<c:if test="${vs.count%2==0}"><c:set value="#ffffff" var="c"/></c:if>
							<tr>
								<td bgcolor="${c }" width="200">酒店名称：${v.name }</td>
								<td bgcolor="${c }" align="center" width="200">房间号：${v.room}</td>
								<td bgcolor="${c }" >入住时间：${v.year }年 &nbsp;${v.month }月&nbsp;${v.day }日</td>
								<td><a href="hotelcancelreserve.do?id=${v.id }">退订</a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			<p/>
			<li><font color="#3e44a1">预订旅游团信息：</font></li><br/>
			<table border="0" cellpadding="0" bordercolor="blue">
				<c:choose>
					<c:when test="${empty groupList}">
						<tr><td><font color="#339922">暂时还未预订任何酒店</font></td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${groupList}" var="v" varStatus="vs">
							<c:if test="${vs.count%2==1}"><c:set value="#ffee99" var="c"/></c:if>
							<c:if test="${vs.count%2==0}"><c:set value="#ffffff" var="c"/></c:if>
							<tr>
								<td bgcolor="${c }" width="200">景点名称：${v.sight }</td>
								<td bgcolor="${c }" align="center" width="200">旅游团：${v.name}</td>
								<td bgcolor="${c }" width="200">预订人数：${v.reservepeople }</td>
								<td><a href="groupcancelreserve.do?id=${v.id }">退订</a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			<p/>
			<li><font color="#3e44a1">预订航班信息：</font></li><br/>
			<table border="0" cellpadding="0" bordercolor="blue">
				<c:choose>
					<c:when test="${empty planeList}">
						<tr><td><font color="#339922">暂时还未预订任何航班</font></td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${planeList}" var="v" varStatus="vs">
							<c:if test="${vs.count%2==1}"><c:set value="#ffee99" var="c"/></c:if>
							<c:if test="${vs.count%2==0}"><c:set value="#ffffff" var="c"/></c:if>
							<tr>
								<td bgcolor="${c }">航班号：${v.number }</td>
								<td bgcolor="${c }">&nbsp;&nbsp;出发城市:${v.fromcity}</td>
								<td bgcolor="${c }">&nbsp;&nbsp;目的城市:${v.destination }</td>
								<td bgcolor="${c }">&nbsp;&nbsp;起飞时间:${v.fly_time }</td>
								<td bgcolor="${c }">&nbsp;&nbsp;到达城市:${v.arrive_time }</td>
								<td bgcolor="${c }">&nbsp;&nbsp;往返类型:${v.fly_type }</td>
								<td bgcolor="${c }">&nbsp;&nbsp;预订座位:${v.reservedPeople }</td>
								<td><a href="planecancelreserve.do?id=${v.id }&number=${v.number}">退订</a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			<table height="50" border="0">
				<tr><td></td></tr>
			</table>
		
		</td></tr>
	</table>
</body>
</html>