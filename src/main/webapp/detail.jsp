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
<a href="list">一覧へ</a><br>
<a href="update.jsp">編集</a>
<h1><%= contribution.getTitle() %></h1><br>
<p><%= contribution.getCreatedDatetime() %></p>
<p><%= contribution.getText() %></p>
</body>
</html>