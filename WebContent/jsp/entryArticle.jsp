<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Entry article</title>
</head>
<body>
<label>記事登録</label>
	<form action="/TinyBBS/EntryArticleServlet" method="post">
		<p><label>タイトル：</label><br><input type="text" name="title" size="40" maxlength="30" placeholder="タイトル"></p>
		<p><label>本文：</label><br><textarea name="body" rows="5" cols="40" placeholder="記事の本文"></textarea></p>
		<p><input type="submit" value="送信する"></p>
	</form>
</body>
</html>