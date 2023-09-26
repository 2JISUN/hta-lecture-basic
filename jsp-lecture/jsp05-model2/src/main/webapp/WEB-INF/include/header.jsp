<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jsp05-model2/css/bootstrap.min.css" />
<link rel="stylesheet" href="/jsp05-model2/css/form.css" />

<script src="../js/bootstrap.bundle.min.js"></script>
<script src="../js/jquery-3.7.1.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js">
</script>
</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
      <a href="../index/index" 
      	 class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
        <svg class="bi me-2" width="40" height="32">
        	<use xlink:href="#bootstrap"></use>
        </svg>
        
        <span class="fs-4">👻 ← click me</span>
      </a>
	<c:choose>
		<%-- <c:when test="${loggedID != null }"> --%>
		<c:when test="${empty loggedID }">
		<ul class="nav nav-pills">
			<li class="nav-item"><a href="../index/index" class="nav-link active"
				aria-current="page">MyHome</a></li>
			<li class="nav-item"><a href="../member/insert" class="nav-link">회원가입</a></li>
			<li class="nav-item"><a href="../member/login" class="nav-link">로그인</a></li>
			<!-- <li class="nav-item"><a href="../board/list.jsp" class="nav-link">게시판</a></li> -->
		</ul>
		</c:when>
		<c:otherwise>
		<ul class="nav nav-pills">
			<li class="nav-item"><a href="../index/index" class="nav-link active"
				aria-current="page">MyHome</a></li>
			<li class="nav-item"><a href="../member/logout" class="nav-link">로그아웃</a></li>
			<li class="nav-item"><a href="../member/info?userID=${loggedID }" class="nav-link">${loggedName }</a></li>
			<li class="nav-item"><a href="../board/list" class="nav-link">게시판</a></li>
		</ul>
		</c:otherwise>
	</c:choose>
    </header>
  </div>
  <!-- header 끝 -->
  
  <main>