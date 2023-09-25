<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>   
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>gugudan.jsp + Gugudan.servlet</h1>
	<h1>구구단 결과</h1>
	<c:set var="dan" value="${param.dan }"></c:set>
	<table border=1>
		<thead>
			<tr>${dan}단</tr>
		</thead>
		
		<tbody>
			<c:forEach var="item"  begin="1" end="9" varStatus="status">
				<tr><td>${dan }*${status.count } = ${dan * status.count }</td></tr>
			</c:forEach>
		</tbody>
	
	</table> 
	


</body>
</html>