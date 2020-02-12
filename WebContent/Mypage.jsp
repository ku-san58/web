<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
</head>
<body>
	<jsp:usebean id="myBean" classs="pac1.MypageBean1" scope="request" />
	<jsp:getproperty name="myBean1" property="list" />


<form action="MypageServlet" method="get">
	<input type="submit" value="新規">
</form>
</body>
</html>