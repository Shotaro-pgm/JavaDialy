<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User loginUser = (User)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>日記</title>
</head>
<body>
<p><%= loginUser.getName() %>さん、こんにちは。</p><br>
<a href="insert">投稿</a>
<a href="logout" onclick="return confirm('ログアウトします。よろしいですか？')">ログアウト</a>
</body>
</html>