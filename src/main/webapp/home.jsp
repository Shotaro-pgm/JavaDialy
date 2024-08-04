<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.User" %>
<%@ page import="bean.Contribution" %>
<%@ page import="java.util.List" %>
<%
User loginUser = (User)session.getAttribute("user");
List<Contribution> contributionList = (List<Contribution>)session.getAttribute("contributionList");
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
<a href="logout" onclick="return confirm('ログアウトします。よろしいですか？')">ログアウト</a><br>
<table>
<tr>
<th>タイトル</th>
<th>投稿日時</th>
</tr>
<% for(Contribution c : contributionList){ %>
<tr>
<td><a href="detail?id=<%= c.getId() %>"><%=c.getTitle() %></a></td>
<td><%=c.getCreatedDatetime() %></td>
</tr>
<% } %>
</table>
</body>
</html>