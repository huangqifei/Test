<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<script type="text/javascript">
	function alt1() {
		alert("��������������");
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
							<td width="20%">&nbsp;&nbsp;����������</td>
							<td width="30%">${group.name }</td>
							<td width="20%">��������</td>
							<td width="30%">${group.maxpeople }</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;�������ƣ�</td>
							<td>${sight.name }</td>
							<td>��������</td>
							<td>${group.haspeople }</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;֧�����ã�</td><td>${group.cost }</td>
							<td>Ԥ��������</td>
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
										<font color="#9911cc">���������Ѿ���</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;��������Ϣ��</td>
							<td>
								<c:if test="${empty groupinfo }">��ʱû�и������ŵ���Ϣ</c:if>
								<c:if test="${!empty groupinfo }">${group.info }</c:if>
							</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;��ʵ������</td><td>${user.name }</td>
						</tr>
						<tr height="31">
							<td>&nbsp;&nbsp;��ϵ�绰��</td><td>${user.telephone }</td>
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