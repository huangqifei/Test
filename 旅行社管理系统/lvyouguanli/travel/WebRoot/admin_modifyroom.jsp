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
	<table border="0" cellpadding="0" cellspacing="0" width="900" align="center">
		<tr>
			<td width="10%">�Ƶ����ƣ�</td>
			<td width="80%">${hotel.name }</td>
		</tr>
		<tr>
			<td>���ڳ��У�</td>
			<td>${hotel.city }</td>
		</tr>
		<tr>
			<td>�Ƶ����ͣ�</td>
			<td>${hotel.star }</td>
		</tr>
		<tr>
			<td>�Ƶ���Ϣ��</td>
			<td>
				<textarea rows="10" cols="40" readonly="readonly" style="font-family: ����">${hotel.info }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:forEach items="${queryList}" var="v">
					<form action="modifyroomensure.do?roomid=${v.id }&hotelid=${hotel.id }" method="post" name="form1">
						�������ͣ�&nbsp;&nbsp;
						<select name="type">
							<c:choose>
								<c:when test="${v.type == '���˷�'}">
									<option value="���˷�" selected="selected">���˷�</option>
									<option value="˫�˷�">˫�˷�</option>
								</c:when>
								<c:otherwise>
									<option value="���˷�">���˷�</option>
									<option value="˫�˷�" selected="selected">˫�˷�</option>
								</c:otherwise>
							</c:choose>
						</select>
						&nbsp;&nbsp;����ţ�
						<input type="text" name="room" value="${v.room }" readonly="readonly" size="4"/>
						
						&nbsp;&nbsp;������ã�
						<input type="text" name="cost" value="${v.cost }" size="6"/>
						&nbsp;&nbsp;�Ƿ�Ԥ����
						<select name="reserved">
							<c:choose>
								<c:when test="${v.reserved == 0}">
									<option value="0" selected="selected">δԤ��</option>
									<option value="1">��Ԥ��</option>
								</c:when>
								<c:otherwise>
									<option value="0">δԤ��</option>
									<option value="1" selected="selected">��Ԥ��</option>
								</c:otherwise>
							</c:choose>
						</select>
						<input type="submit" value="ȷ���޸�"/>&nbsp;&nbsp;
						<a href="adminlistroom.do?id=${hotel.id}">������д</a>
						<a href="roomdelete.do?id=${v.id }&hotelid=${hotel.id }">ɾ��</a>
					</form>
				</c:forEach>
			</td>
		</tr>
		<tr height="40" width="900" align="center" valign="middle">
			<td><a href="admin_addroom.jsp?id=${hotel.id }">��ӷ���</a></td>
		</tr>
	</table>
</body>
</html>