<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  	<%@ include file="logo.jsp" %>
    <table width="900" height="800" border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td width="190">
				<table width="190" height="800" border="0" cellpadding="0" cellspacing="0">
					<tr height="132">
						<td>
							<table height="130"  width="190" border="1" cellpadding="0" cellspacing="0" bordercolor="#167bd6">
								<tr height="28">
									<td width="190" background="img/left_bg.jpg">
										&nbsp;<img src="img/pic_arrow_011.gif"/><font color="#ffffff">&nbsp;用户登陆</font>
									</td>
								</tr>
								<!-- #f7fbff -->
								<c:if test="${empty user}">
									<tr height="102">
										<td bgcolor="#f7fbff">
											<form action="login.do" method="post" name="form1">
											   <div style="padding-left:15px;padding-top:15px;">
												用户名：<input type="text" name="name" size="15"><br>
												密&nbsp;&nbsp;码：<input type="password" name="password" id="name" size="15"><br>
												&nbsp;&nbsp;<img src="img/login.jpg" onclick="form1.submit()"/>&nbsp;
												<a href="register_user.jsp"><img src="img/reset.gif"/></a><br/>
												${message }
												</div>
											</form>
										</td>
									</tr>
								</c:if>
								<c:if test="${!empty user}">
									<tr height="102">
										<td background="img/login_2.gif"></td>
									</tr>
								</c:if>
							</table>
						</td>
					</tr>
					<tr height="3"><td width="190"></td></tr>
					<tr height="665">
						<td width="190">
							<table height="665"  width="190" border="1" cellpadding="0" cellspacing="0" bordercolor="#167bd6">
								<tr height="28">
									<td width="190" background="img/left_bg.jpg">
										&nbsp;<img src="img/pic_arrow_011.gif"/><font color="#ffffff">&nbsp;友情链接</font>
									</td>
								</tr>
								<tr height="637">
									<td width="190" valign="top">
										<table boder="0" height="500">
											<tr>
												<td><a href="http://www.cncn.com">欣欣旅游网</a></td>
											</tr>
											<tr>
												<td><a href="http://www.mangocity.com">芒果网</a></td>
											</tr>
											<tr>
												<td><a href="http://www.elong.com">艺龙旅游网</a></td>
											</tr>
											<tr>
												<td><a href="http://www.ctrip.com">携程旅行网</a></td>
											</tr>
											<tr>
												<td><a href="http://www.go2eu.com">穷游网</a></td>
											</tr>
											<tr>
												<td><a href="http://www.17u.net">同程网</a></td>
											</tr>
											<tr>
												<td><a href="http://www.lotour.com">乐途旅游网</a></td>
											</tr>
											<tr>
												<td><a href="http://www.tuniu.com">途牛旅游网</a></td>
											</tr>
											<tr>
												<td><a href="http://www.51766.com">中国通用旅游</a></td>
											</tr>
											<tr>
												<td><a href="http://www.cnta.com">国家旅游局</a></td>
											</tr>
											<tr>
												<td><a href="http://www.yododo.com">游多多</a></td>
											</tr>
										</table>
										<table>
											<tr>
												<td>
													<img src="img/sight.jpg"/>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
			<td width="3" height="800">&nbsp;</td>
			<!-- right -->
			<td width="707" height="800">
				<table border="1" cellpadding="0" cellspacing="0" width="707" height="330" bordercolor="#7eb500">
					<tr><td>
						<table border="0" cellpadding="0" cellspacing="0"  width="705" height="330">
							<tr height="30">
								<td background="img/green.jpg" colspan="2"></td>
							</tr>
							<tr>
								<td valign="top" width="130">
									<div class="right">
										<img src="img/index_sight.jpg">
									</div>
								</td>
								<td width="550" valign="top">
									<div class="second">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr><td>景点名称</td></tr>
											<tr><td><table>
												<c:set var="var1" value="#f7ffe8"/>
												<c:set var="var2" value="#edf9d0"/>
												<c:forEach items="${sight}" var="v" end="19" varStatus="vs">
													<c:if test="${vs.count%5==1 && vs.count>1}">
														<c:set var="var3" value="${var1}"/>
														<c:set var="var1" value="${var2}"/>
														<c:set var="var2" value="${var3}"/>
														<tr height="10">
													</c:if>
													<td align="center" width="100" bgColor="${var1 }"><a href="indexsight.do?id=${v.id}">${v.name }</a></td>
													<td> ┆ </td>
													<c:if test="${vs.count % 5 == 0}">
														</tr>
													</c:if>
												</c:forEach>
											</table></td></tr>
										</table>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2" height="120">城市名称：<table>
									<c:set var="var1" value="#f7ffe8"/>
												<c:set var="var2" value="#edf9d0"/>
												<c:forEach items="${sightName}" var="v" end="19" varStatus="vs">
													<c:if test="${vs.count%5==1 && vs.count>1}">
														<c:set var="var3" value="${var1}"/>
														<c:set var="var1" value="${var2}"/>
														<c:set var="var2" value="${var3}"/>
														<tr height="10">
													</c:if>
													<td align="center" width="100" bgColor="${var1 }"><a href="indexcity.do?id=${v.id}">${v.city }</a></td>
													<td> ┆ </td>
													<c:if test="${vs.count % 5 == 0}">
														</tr>
													</c:if>
												</c:forEach>
								</table></td>
							</tr>
						</table>
					</td></tr>
					
				</table>
				<table border="1" cellpadding="0" cellspacing="0" width="707" height="240" bordercolor="#ff9900">
					<tr height="30">
						<td background="img/yellow.jpg"></td>
					</tr>
					<tr height="210">
						<td>
							<table width="707" border="0" cellpadding="0" cellspacing="0">
								<tr heright="100">
									<td width="707"><table width="707" cellpadding="0" cellspacing="0" border="0">
										<tr height="10"><td colspan="10">酒店名称：<br/></td></tr>
										<c:forEach items="${hotel}" var="v" end="10" varStatus="vs">
											<c:if test="${vs.count==6 && vs.count>1}">
												<tr height="45">
											</c:if>
													<td width="20%">
														<a href="indexhotel.do?id=${v.id }">${v.name}</a>
													</td>
											<c:if test="${vs.count==11 && vs.count>1}">
												</tr>
											</c:if>
										</c:forEach>
									</table></td>
								</tr>
								<tr height="100">
									<td height="100" width="707">
										<table height="100" width="707" border="0" cellpadding="0" cellspacing="0">
											<tr height="100">
												<td width="550" height="10" colspan="5">航班信息：</td>	
											</tr>
											<c:forEach items="${plane}" var="v" end="10" varStatus="vs">
											<c:if test="${vs.count==6 && vs.count>1}">
												<tr height="45">
											</c:if>
													<td width="50">
														<a href="indexplane.do?id=${v.id }">${v.number}</a>&nbsp;&nbsp;
													</td>
											<c:if test="${vs.count==11 && vs.count>1}">
												</tr>
											</c:if>
											</c:forEach>
										</table>
									<td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table border="1" cellpadding="0" cellspacing="0" width="707" height="200" bordercolor="#1b930d">
					<tr height="30">
						<td background="img/green1.jpg"></td>
					</tr>
					<tr height="200">
						<td>
							<table border="0" cellpadding="0" cellspacing="0" width="707" height="190">
								<tr height="20">
									<td align="center" width="607">标题</td><td align="center" width="100">日期</td>
								</tr>
								<c:forEach items="${bbsList}" begin="0" end="5" var="v">
									<tr height="20">
										<td align="left" width="607"><a href="seeposts.do?id=${v.id }">${v.name }</a></td>
										<td align="left" width="100">${v.date }</td>
									</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
  </body>
</html>
