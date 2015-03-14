<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
	<style type="text/css" media="screen">
		<!--
		BODY{
			FONT-SIZE:11pt;
		}
		a:link { text-decoration: none;color: green}
　　 	a:active { text-decoration:blink; }
　　		a:hover { text-decoration: none;color: f66b2e;} 
　　 	a:visited { text-decoration: none;color: #3f8c00; }
		.right {margin-left:10px;margin-top: 10px; height: 120}		
		.second {margin-left:10px;margin-top: 12px;}
		a img {border:none;}
		
		-->
	</style>
</head>
<body>
	<table width="900" height="91" border="0" cellpadding="0" cellspacing="0" align="center">
		<tr height="91">
				<td width="773"><img src="img/logo1.gif"/><img src="img/logo2.jpg"/></td>
				<td width="127"></td>
		</tr>
	</table>
	<table width="900" height="38" border="0" cellpadding="0" cellspacing="0" align="center">
		<tr height="37">
				<td width="98" align="left"><a href="welcome.do"><img src="img/index.gif" /></a></td>
				<td width="98" align="left"><a href="logosight.do"><img src="img/sight.gif"/></a></td>
				<td width="98" align="left"><a href="logohotel.do"><img src="img/hotel.gif"/></a></td>
				<td width="98" align="left"><a href="logoplane.do"><img src="img/plane.gif"/></a></td>
				<td width="98" align="left"><a href="logobbs.do"><img src="img/bbs.gif"/></a></td>
				<td width="410" height="37" background="img/logoblank.gif" align="right">
					<font style="font-size: 15px;">
						<c:if test="${empty user}"><a href="login.jsp">登陆</a></c:if>
						<c:if test="${!empty user}">
							<c:choose>
								<c:when test="${user.admin==true}">
									管理员：${user.name }&nbsp;|&nbsp;<a href="logout.do">退出</a>
								</c:when>
								<c:otherwise>
									游客：<a href="confirm.do">${user.name }</a>&nbsp;|&nbsp;<a href="logout.do">退出</a>
								</c:otherwise>
							</c:choose>
						</c:if> 
					</font>
				</td>
		</tr>
		<tr height="1"></tr>
	</table>
</body>
</html>