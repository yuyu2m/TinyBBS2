<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
<label>Tiny BBS ログインページ</label>
	<form action="/TinyBBS/LoginServlet" method="post">
		<p><label>ログインID：<input type="text" name="id" size="40" maxlength="20"></label></p>
		<p><label>パスワード：<input type="password" name="password" size="40" maxlength="20"></label></p>
		<p><input type="submit" value="ログイン"></p>
	</form>
	<a href=/TinyBBS/jsp/entryUser.jsp>ユーザ登録</a>
	<br>
</body>
</html>