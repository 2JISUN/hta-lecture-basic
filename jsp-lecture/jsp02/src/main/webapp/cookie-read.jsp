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
		Cookie cookies[] = request.getCookies();
		if(cookies!=null){
			for(Cookie c : cookies){
				out.println(c.getName()+" : "+c.getValue());
				out.println("<br>");
			} 
		}else {
			out.println("<h1>쿠키없음</h1>");
		}
	%>
</body>
</html>