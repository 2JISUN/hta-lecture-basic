<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
		String name = "이지선";
		int age = 28;
	
	%>
	<h1>hello jsp</h1>
	<h2>이름은 <% out.println(name); %>입니다.</h2>
	<h2>나이는 <% out.println(age); %>입니다.</h2>
	<a href="hi.jsp?name=이마크&age=1999">hi</a>
</body>
</html>