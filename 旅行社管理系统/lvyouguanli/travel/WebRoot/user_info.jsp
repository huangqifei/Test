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
			<h1>�û�������Ϣ</h1>
			<hr/>
			�û���:${user.name }<br/>
			��ʵ������${user.tname }<br/>
			��ϵ�绰��${user.telephone }<br/>
			���䣺${user.email }<br/>
			<a href="modify_info.jsp">�޸ĸ�����Ϣ</a>
			<a href="welcome.do">������ҳ</a>
			<li><font color="#3e44a1">Ԥ���Ƶ���Ϣ��</font></li><br/>
			<table border="0" cellpadding="0" bordercolor="blue">
				<c:choose>
					<c:when test="${empty hotelList}">
						<tr><td><font color="#339922">��ʱ��δԤ���κξƵ�</font></td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${hotelList}" var="v" varStatus="vs">
							<c:if test="${vs.count%2==1}"><c:set value="#ffee99" var="c"/></c:if>
							<c:if test="${vs.count%2==0}"><c:set value="#ffffff" var="c"/></c:if>
							<tr>
								<td bgcolor="${c }" width="200">�Ƶ����ƣ�${v.name }</td>
								<td bgcolor="${c }" align="center" width="200">����ţ�${v.room}</td>
								<td bgcolor="${c }" >��סʱ�䣺${v.year }�� &nbsp;${v.month }��&nbsp;${v.day }��</td>
								<td><a href="hotelcancelreserve.do?id=${v.id }">�˶�</a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			<p/>
			<li><font color="#3e44a1">Ԥ����������Ϣ��</font></li><br/>
			<table border="0" cellpadding="0" bordercolor="blue">
				<c:choose>
					<c:when test="${empty groupList}">
						<tr><td><font color="#339922">��ʱ��δԤ���κξƵ�</font></td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${groupList}" var="v" varStatus="vs">
							<c:if test="${vs.count%2==1}"><c:set value="#ffee99" var="c"/></c:if>
							<c:if test="${vs.count%2==0}"><c:set value="#ffffff" var="c"/></c:if>
							<tr>
								<td bgcolor="${c }" width="200">�������ƣ�${v.sight }</td>
								<td bgcolor="${c }" align="center" width="200">�����ţ�${v.name}</td>
								<td bgcolor="${c }" width="200">Ԥ��������${v.reservepeople }</td>
								<td><a href="groupcancelreserve.do?id=${v.id }">�˶�</a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			<p/>
			<li><font color="#3e44a1">Ԥ��������Ϣ��</font></li><br/>
			<table border="0" cellpadding="0" bordercolor="blue">
				<c:choose>
					<c:when test="${empty planeList}">
						<tr><td><font color="#339922">��ʱ��δԤ���κκ���</font></td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${planeList}" var="v" varStatus="vs">
							<c:if test="${vs.count%2==1}"><c:set value="#ffee99" var="c"/></c:if>
							<c:if test="${vs.count%2==0}"><c:set value="#ffffff" var="c"/></c:if>
							<tr>
								<td bgcolor="${c }">����ţ�${v.number }</td>
								<td bgcolor="${c }">&nbsp;&nbsp;��������:${v.fromcity}</td>
								<td bgcolor="${c }">&nbsp;&nbsp;Ŀ�ĳ���:${v.destination }</td>
								<td bgcolor="${c }">&nbsp;&nbsp;���ʱ��:${v.fly_time }</td>
								<td bgcolor="${c }">&nbsp;&nbsp;�������:${v.arrive_time }</td>
								<td bgcolor="${c }">&nbsp;&nbsp;��������:${v.fly_type }</td>
								<td bgcolor="${c }">&nbsp;&nbsp;Ԥ����λ:${v.reservedPeople }</td>
								<td><a href="planecancelreserve.do?id=${v.id }&number=${v.number}">�˶�</a></td>
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