<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>JSTL</title>
</head>
<body>
	<h1>Test JSTL</h1>
    <hr/>
    <li>Test c:out</li><br/>
    hello(default):${hello }<br/>
    hello(jstl):<c:out value="${hello}"/><br/>
    <li>Test c:out html</li><br/>
    bj(escapeXml true):<c:out value="${bj}" escapeXml="true"/><br/>
    bj(escapeXml false):<c:out value="${bj }" escapeXml="false"/><br/>
    bj(el)${bj }<br/>
    <li>Test c:set c:remove</li><br/>
    <c:set value="123" var="x"/>
    num:${x }<br/>
    <c:remove var="x"/>
    num:${x }<br/>
    <li>Test c:if</li><br/>
    <c:if test="${empty att1}">
    	attr1 为空<br/>
    </c:if>
    <c:if test="${empty att2 }">
    	attr2 为空<br/>
    </c:if>
    <li>测试条件标签: c:choose c:when c:otherwise</li><br/>
    <c:choose>
    	<c:when test="${v1 lt v2}">
    		v1:${v1 }小于v2:${v2 }
    	</c:when>
    	<c:otherwise>
    		v1:${v1 }大于v2:${v2 }
    	</c:otherwise>
    </c:choose>
    <p/>
    <li>测试循环控制c:forEach </li><br/>
    <table border="1">
    	<tr>
    		<td>姓名</td>
    		<td>年龄</td>
    		<td>组名</td>
    	</tr>
    	<c:choose>
    		<c:when test="${empty userList}">
    			<tr>
    				<td colspan="3">没有符合的数据</td>
    			</tr>
    		</c:when>
    		<c:otherwise>
    			<c:forEach items="${userList}" var="v">
	    			<tr>
	    				<td>${v.name }</td>
	    				<td>${v.age }</td>
	    				<td>${v.group.name }</td>
	    			</tr>
	  			</c:forEach>
    		</c:otherwise>
    	</c:choose>
    </table>
    <!-- 没有找到符合的数据 -->
    <table border="1">
    	<tr>
    		<td>姓名</td>
    		<td>年龄</td>
    		<td>组名</td>
    	</tr>
    	<c:choose>
    		<c:when test="${empty userList1}">
    			<tr>
    				<td colspan="3">没有符合的数据</td>
    			</tr>
    		</c:when>
    		<c:otherwise>
    			<c:forEach items="${userList}" var="v">
	    			<tr>
	    				<td>${v.name }</td>
	    				<td>${v.age }</td>
	    				<td>${v.group.name }</td>
	    			</tr>
	  			</c:forEach>
    		</c:otherwise>
    	</c:choose>
    </table>
    <p/>
    <li>测试循环控制c:forEach, varStatus</li>
    <table border="1">
    	<tr>
    		<td>姓名</td>
    		<td>年龄</td>
    		<td>组名</td>
    	</tr>
    	<c:choose>
    		<c:when test="${empty userList }">
    			<tr>
    				<td colspan="3" align="center">没有找到相对应的数据</td>
    			</tr>
    		</c:when>
    		<c:otherwise>
    			<c:forEach items="${userList }" var="vv" varStatus="vs">
    				<c:choose>
    					<c:when test="${vs.count % 2 == 0}">
    						<tr bgcolor="yellow">
    							<td>${vv.name }</td>
    							<td>${vv.age }</td>
    							<td>${vv.group.name }</td>
    						</tr>
    					</c:when>
    					<c:otherwise>
    						<tr>
    							<td>${vv.name }</td>
    							<td>${vv.age }</td>
    							<td>${vv.group.name }</td>
    						</tr>
    					</c:otherwise>
    				</c:choose>
    			</c:forEach>
    		</c:otherwise>
    	</c:choose>
    	
    </table>
    <p/>
    <li>测试循环控制c:forEach, varStatus, begin, end, step </li>
        <table border="1">
    	<tr>
    		<td>姓名</td>
    		<td>年龄</td>
    		<td>组名</td>
    	</tr>
    	<c:choose>
    		<c:when test="${empty userList }">
    			<tr>
    				<td colspan="3" align="center">没有找到相对应的数据</td>
    			</tr>
    		</c:when>
    		<c:otherwise>
    			<c:forEach items="${userList }" var="vv" begin="2" end="9" step="2">
    				<tr>
    					<td>${vv.name }</td>
    					<td>${vv.age }</td>
    					<td>${vv.group.name }</td>
    				</tr>
    			</c:forEach>
    		</c:otherwise>
    	</c:choose>
    	
    </table>
    <p/>
    <li>循环打印字符10次</li><br/>
    <c:forEach begin="1" end="10" varStatus="vs">
    	print ten times....${vs.count }<br/>
    </c:forEach>
    <p/>
    <li>循环打印map</li><br/>
    <c:forEach items="${map}" var="map">
    	${map.key }=${map.value }<br/>
    </c:forEach>
    <p/>
    <li>测试循环控制标签c:forTokens</li><br/>
    <c:forTokens items="${char}" delims="," var="char">
    	${char }<br/>
    </c:forTokens>
    <li>测试c:catch</li><br/>
    <%
    	try {
    		int i = Integer.parseInt("abc");
    	} catch(Exception e) {
    		out.println(e.getMessage() + "&nbsp;one");
    	}
     %>
     <p/>
     <c:catch var="errInfo">
     	<%int i = Integer.parseInt("abc"); %>
     </c:catch>
     ${errInfo }&nbsp;two<br/>
</body>
</html>