<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>

<style type="text/css">
 table td {text-align:left;}

</style>
</head>
<body>
	<%@ include file="logo.jsp" %>
	
	<table border="0" width="900" align="center" >
		<tr><td>
			<hr/>
			<form action="queryhotel.do" method="post">
				城市：<input type="text" name="city" size="15"/>&nbsp;&nbsp;
				酒店类型（星级）<input type="text" name="star" size="15"/>&nbsp;&nbsp;
				酒店名称：<input type="text" name="name" size="15"/>
				<input type="submit" value="查询"/>
			</form>
		</td></tr>
	</table>
	<c:forEach items="${hotelList}" var="v">
		<p/> 
		<table align="center" width="700">
			<tr>
				<td><img src="img/default_pic_small.gif"/></td>
				<td align="left" width="500"> 
					<table border="0" width="600" height="120">
						<tr>
							<td width="25%" align="center">酒店名称：</td>
							<td width="75%" align="left"><a href="indexhotel.do?id=${v.id }">${v.name}</a></td>
						</tr>
						<tr>
							<td align="center">所在城市：</td><td>${v.city }</td>
						</tr>
						<tr>
							<td align="center">酒店等级（星级）：</td>
							<td>${v.star }</td>
						</tr>
						<tr>
							<td align="center">酒店信息：</td><td>${v.info }</td>
						</tr>
		</table></td></tr></table>
	</c:forEach>
</body>
</html>