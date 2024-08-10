<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.Contribution" %>
<%
Contribution contribution = (Contribution)session.getAttribute("contribution");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>日記</title>
</head>
<body>
<form action="update" method="post">
タイトル：<input type="text" name="title" value="<%= contribution.getTitle() %>"><br>
本文：<textarea name="text"><%= contribution.getText() %></textarea><br>
<input type="hidden" name="id" value="<%= contribution.getId() %>">
<input type="submit" value="編集する">
</form>
</body>
</html>