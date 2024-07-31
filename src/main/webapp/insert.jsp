<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>日記</title>
</head>
<body>
<h1>投稿</h1>
<form action="insert" method="post">
タイトル：<input type="text" name="title"><br>
本文：<textarea name="text"></textarea><br>
<input type="submit" value="投稿する"> 
</form>
</body>
</html>