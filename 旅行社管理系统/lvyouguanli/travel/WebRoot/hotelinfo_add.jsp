<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>
	<h1>�Ƶ���Ϣע��</h1>
	<form action="add_hotelinfo.do" method="post">
		�Ƶ����ƣ�<input type="text" name="name" size="10"/><br/>
		���ڳ��У�<input type="text" name="city" size="5"/><br/>
		�Ƶ�ȼ���<input type="text" name="star" size="5"/><br/>
		���ã�<input type="text" name="fee" size="5"/><br/>
		�ۿۣ�<input type="text" name="discount" size="5"/><br/>
		�Ƶ���Ϣ��<textarea rows="5" cols="20"  name="info"></textarea><br/>
		<input type="submit" value="ȷ��"/>&nbsp;<input type="reset" value="����"/>
	</form>
</body>
</html>