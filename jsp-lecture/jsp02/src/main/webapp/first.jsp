<%@page import="common.Person"%>
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
		Person person = new Person("이",99);
		String name = "이지선";
		int age = 28;
		// pageContext < *request* < *session* < application
		pageContext.setAttribute("name","페이지콘텍스트");
		request.setAttribute("name","리퀘스트");
		session.setAttribute("name","세션");
		application.setAttribute("name","애플리케이션");
		
		out.println("scope====");
		String pageContextName = (String)pageContext.getAttribute("name");
		String requestName = (String)request.getAttribute("sun");
		String sessionName = (String)session.getAttribute("name");
		String applicationName = (String)application.getAttribute("name");
		
		out.println(pageContextName);
		out.println("<hr>");
		out.println(requestName);
		out.println("<hr>");
		out.println(sessionName);
		out.println("<hr>");
		out.println(applicationName);
		
		
		
		request.getRequestDispatcher("second.jsp").forward(request, response);
		//response.sendRedirect("third.jsp");
		
	%>
	<a href="second.jsp">second</a> <br>
	<a href="third.jsp">second</a> <br>
	
	

</body>
</html>

































































