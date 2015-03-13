<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>
	<h1>酒店信息注册</h1>
	<form action="add_hotelinfo.do" method="post">
		酒店名称：<input type="text" name="name" size="10"/><br/>
		所在城市：<input type="text" name="city" size="5"/><br/>
		酒店等级：<input type="text" name="star" size="5"/><br/>
		费用：<input type="text" name="fee" size="5"/><br/>
		折扣：<input type="text" name="discount" size="5"/><br/>
		酒店信息：<textarea rows="5" cols="20"  name="info"></textarea><br/>
		<input type="submit" value="确定"/>&nbsp;<input type="reset" value="重置"/>
	</form>
</body>
</html>