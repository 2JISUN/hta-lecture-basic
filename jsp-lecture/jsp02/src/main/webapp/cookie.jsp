<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠기 설정</h1>
	<%
		Cookie cookie = new Cookie("myCookie","이웃집통통이약과쿠키");
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(10);
		response.addCookie(cookie);
		out.println(request.getContextPath());
	
	%>

</body>
</html>