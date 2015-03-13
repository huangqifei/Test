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
			<td width="10%">酒店名称：</td>
			<td width="80%">${hotel.name }</td>
		</tr>
		<tr>
			<td>所在城市：</td>
			<td>${hotel.city }</td>
		</tr>
		<tr>
			<td>酒店类型：</td>
			<td>${hotel.star }</td>
		</tr>
		<tr>
			<td>酒店信息：</td>
			<td>
				<textarea rows="10" cols="40" readonly="readonly" style="font-family: 黑体">${hotel.info }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:forEach items="${queryList}" var="v">
					<form action="modifyroomensure.do?roomid=${v.id }&hotelid=${hotel.id }" method="post" name="form1">
						房间类型：&nbsp;&nbsp;
						<select name="type">
							<c:choose>
								<c:when test="${v.type == '单人房'}">
									<option value="单人房" selected="selected">单人房</option>
									<option value="双人房">双人房</option>
								</c:when>
								<c:otherwise>
									<option value="单人房">单人房</option>
									<option value="双人房" selected="selected">双人房</option>
								</c:otherwise>
							</c:choose>
						</select>
						&nbsp;&nbsp;房间号：
						<input type="text" name="room" value="${v.room }" readonly="readonly" size="4"/>
						
						&nbsp;&nbsp;房间费用：
						<input type="text" name="cost" value="${v.cost }" size="6"/>
						&nbsp;&nbsp;是否预订：
						<select name="reserved">
							<c:choose>
								<c:when test="${v.reserved == 0}">
									<option value="0" selected="selected">未预订</option>
									<option value="1">己预订</option>
								</c:when>
								<c:otherwise>
									<option value="0">未预订</option>
									<option value="1" selected="selected">己预订</option>
								</c:otherwise>
							</c:choose>
						</select>
						<input type="submit" value="确认修改"/>&nbsp;&nbsp;
						<a href="adminlistroom.do?id=${hotel.id}">重新填写</a>
						<a href="roomdelete.do?id=${v.id }&hotelid=${hotel.id }">删除</a>
					</form>
				</c:forEach>
			</td>
		</tr>
		<tr height="40" width="900" align="center" valign="middle">
			<td><a href="admin_addroom.jsp?id=${hotel.id }">添加房间</a></td>
		</tr>
	</table>
</body>
</html>