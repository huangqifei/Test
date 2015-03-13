<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <table width="900" height="800" border="0" cellpadding="0" cellspacing="0" align="center">
		<tr height="800">
			<td width="177">
				<table width="177" height="130" border="1" cellpadding="0" cellspacing="0" bordercolor="#167bd6">
					<tr height="28">
						<td width="177" background="img/left_bg.jpg">
							&nbsp;<img src="img/pic_arrow_011.gif"/><font color="#ffffff">&nbsp;用户登陆</font>
						</td>
					</tr>
					<!-- #f7fbff -->
					<tr height="102">
						<td bgcolor="#f7fbff">
							<form action="login.do" method="post">
								<input type="text" name="name"><br>
								<input type="password" name="password"><br>
								<img src="img/login.jpg"/>&nbsp;&nbsp;&nbsp;<img src="img/reset.gif"/>
								<p>${message }</p>
							</form>
						</td>
					</tr>
				</table>
				<table height="1" width="177" border="0" cellpadding="0" cellspacing="0">
					<tr><td>&nbsp;</td></tr>
				</table>
				<table>
					<tr height="28">
						<td width="177" background="img/left_bg.jpg">
							&nbsp;<img src="img/pic_arrow_011.gif"/><font color="#ffffff">&nbsp;用户登陆</font>
						</td>
					</tr>
					<tr height="665">
						<td width="177"></td>
					</tr>
				</table>
			</td>
			<td width="3" height="800">&nbsp;</td>
			<td width="720" height="800">
				<table border="0" cellpadding="0" cellspacing="0" width="720" height="800">
					<tr height="30">
						<td><img src="img/green.jpg"/></td>
					</tr>
					<tr height="300">
						<td>&nbsp;</td>
					</tr>
					<tr height="30">
						<td><img src="img/yellow.jpg"/></td>
					</tr>
					<tr height="210">
						<td>&nbsp;</td>
					</tr>
					<tr height="30">
						<td><img src="img/green1.jpg"/></td>
					</tr>
					<tr height="200">
						<td>&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
  </body>
</html>
