<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
</head>
<body>
<form action="sinki_toukou.html" method="get">
<%
import java.util.List;
import foo.bar.Bean;

List<Bean> list = (List<Bean>) request.getAttribute("DiaryList");
%>

<table>
    <tr>
        <th>ID</th>
        <th>名前</th>
    </tr>
    <% for (Bean bean : list) { %>
    <tr>
        <td><%= bean.getId() %></td>
        <td><%= bean.getName() %></td>
    </tr>
    <% } %>
</table>
	
	<input type="submit" value="新規投稿">
	</form>
</body>
</html>