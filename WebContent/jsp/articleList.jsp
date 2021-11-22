<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page import ="beans.Article" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Article list page</title>
</head>
<body>
<label>記事一覧</label><br><br>
<a href = /TinyBBS/jsp/entryArticle.jsp>新規記事登録</a><br><br>
	<%
		List<Article> aList = (List<Article>)( request.getAttribute("articleList") );
	%>
	<%
		for(Article a : aList){
	%>

		<!-- <label><%out.append( String.valueOf(a.getId() ) ); %></label> <br> -->
		<label>タイトル：<br><%out.append( a.getTitle() ); %></label> <br>
		<label>本文：<br><%out.append( a.getBody() ); %></label> <br>
		<label>登録者：<br><%out.append( a.getEditorId() ); %></label> <br>
		<%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");%>
		<label>登録日時：<br><%out.append( sdf.format( a.getEntryDatetime() ) ); %></label> <br>
		<br>
	<%} %>
</body>
</html>