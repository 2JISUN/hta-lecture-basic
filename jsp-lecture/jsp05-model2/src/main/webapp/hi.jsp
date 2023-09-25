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

	<h1> Model2️⃣ test : hi.jsp + Hi.servlet </h1>
	<h2> ⭐Hi.java⭐에서 실행되는 중 </h2>
	<h3> 이름 : ${me.name}</h3>
	<h3> 별명 : ${me.nickName}</h3>
	<h3> 나이 : ${me.age}</h3>
	<h3> 성별 : ${me.gender}</h3>
	
	<ul>
		<c:forEach items="${personList}" var="item" begin="3" end="6" varStatus="loop">
			<li>
				<%-- <div>${loop.count}</div> <!-- 게시판에서 글 번호 매길 때 주로 사용 : 순서대로 --> --%>
				<div>${loop.end - loop.index}</div> <!-- 게시판에서 글 번호 매길 때 주로 사용 : 역순으로-->
				<%-- <div>${loop.index}</div> --%>
				<div>이름 : ${item.name}</div>
				<div>별명 : ${item.nickName}</div>
				<div>나이 : ${item.age}</div>
				<div>성별 : ${item.gender}</div>
			</li>
		</c:forEach>

		
		
	</ul>
	
	<ul>
		<c:forEach  begin="1" end="100" step="1" var="item">
			<%-- <c:if test = "${item % 2 != 0}"> --%>
			<c:if test = "${item mod 2 ne 0}">
				<li>${item}</li>
			</c:if>
		</c:forEach>
	</ul>
	
	
	<!-- 변수 범위 설정 : 페이지, 리퀘스트, 세션, 애플리케이션-->
	<c:set var="name" value="마크">	</c:set>
	
	<c:choose>
		<c:when test="${'이지선' eq name }">
			<p>이지선이 맞습니다.</p>
		</c:when>
		<c:when test="${'마크' eq name }">
			<p>마크가 맞습니다.</p>
		</c:when>
		<c:otherwise>
			<p>이지선이 아닙니다.</p>
		</c:otherwise>
			
	</c:choose>

		
	
	
			

</body>
</html>