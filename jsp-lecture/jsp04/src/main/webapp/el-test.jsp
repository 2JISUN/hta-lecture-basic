<%@page import="util.CookieManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>&lt;p&gt;${20+10 }</p>
	<p>\${20-10 } : ${20-10 }</p>
	<p>\${20*10 } : ${20*10 }</p>
	<p>\${20/10 } : ${20/10 }</p>
	<p>\${20>10 } : ${20>10 }</p>
	<p>\${20 > 10 } : ${20 gt 10 }</p>
	<p>\${"jisun" eq "jisun"} : ${"jisun" eq "jisun"}</p>
	<p>\${"jisun" ne "jisum"} : ${"jisun" ne "jisum"}</p>
	
	<%
		String emptyString = "";
		String emptyNull = null;
		String emptyArray[] = null;
		List<String> emptyList = new ArrayList<>();
		Map<String,String> map = new HashMap<>();
		CookieManager.createCookie(response, "Elcookie", "지선", 60*60);
		/* 변수를 저장하는 영역 */
		pageContext.setAttribute("name", "pageContext 지선");
		request.setAttribute("name", "request 지선");
		session.setAttribute("name", "session 지선");
		application.setAttribute("name", "application 지선");
		
		
		
	%>
	<p>${empty emptyString}</p>
	<p>${empty emptyNull}</p>
	<p>${empty emptyArray}</p>
	<p>${empty emptyList}</p>
	<p>${empty map}</p>
	

	<h3>범위.변수출력</h3>
	<p>${pageScope.name}</p>
	<p>${requestScope.name}</p>
	<p>${sessionScope.name}</p>
	<p>${applicationScope.name}</p>
	
	<h3>범위를 생략해도 출력가능 (작은것부터 접근한다)</h3>
	<p>${name}</p>
	

	<p>${header["user-agent"]}</p>
	<p>${param.age}</p>
	
	
</body>
</html>



















