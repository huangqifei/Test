<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<script type="text/javascript">
	function alt1() {
		alert("航班人数已满");
	}
</script>
</head>
<body>
	<%@ include file="logo.jsp" %>
	<form action="fillplaneinfo.do?id=${plane.id }" method="post" name="form1">
		<table align="center" width="900">
			<tr>
				<td valign="top"><img src="img/default_pic.gif"/></td>
				<td align="left" width="700">
					<table border="0" width="700" height="250">
						<tr height="31">
							<td width="20%">&nbsp;&nbsp;航班号：</td>
							<td width="30%">${plane.number }</td>
							<td width="20%">往返类型：</td>
							<td width="30%">
								<select name="fly_type">
									<option value="1">单程</option>
									<option value="1">往返</option>
								</select>
							</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;出发城市：</td><td>${plane.fromcity }</td>
							<td>目的城市：</td><td>${plane.destination}</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;起飞时间：</td><td>${plane.fly_time }</td>
							<td>单程价格：</td><td>${plane.fee }</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;到达时间：</td><td>${plane.arrive_time }</td>
							<td>己有人数：</td><td>${plane.haspeople }</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;真实姓名：</td><td>${user.name }</td>
							<td>总人数：</td><td>${plane.maxpeople }</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;联系电话：</td><td>${user.telephone }</td>
							<td>预订人数</td>
							<td>
								<c:set value="${plane.maxpeople - plane.haspeople}" var="p"/>
								<c:choose>
									<c:when test="${p != 0}">
										<select name="reservedpeople">
											<c:forEach begin="1" end="${p}" step="1" varStatus="vs">
												<option value="${vs.count}">${vs.count}</option>
											</c:forEach>
										</select>
									</c:when>
									<c:otherwise>
										<font color="#9911cc">本航班已经满</font>
									</c:otherwise>
								</c:choose>
							</td>
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