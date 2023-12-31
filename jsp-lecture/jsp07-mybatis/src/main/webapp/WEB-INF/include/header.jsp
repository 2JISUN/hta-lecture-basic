<%@ page language="java" 
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿄쿄쿄</title>

<script src="../js/jquery-3.7.1.min.js"></script>
<script src="../js/bootstrap.bundle.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/font_bootstrap-icons.css">
<link rel="stylesheet" href="../css/layout.css">


</head>
<body>
<header class="p-3 mb-3 border-bottom">
	<!-- 부트스트랩 이미지 삽입하기 -->
	<!-- 방법01 -->
	<!-- <img src="../icons/apple.svg" style="width:100px"> -->
	<!-- 방법02 -->
	<i class="bi bi-apple" style=""></i>
	
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 link-body-emphasis text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <!-- 로그인 -->
          <li>
         	 <a href="../member/login" class="nav-link px-2 link-secondary">로그인</a>
          </li>
          <!-- 회원가입 -->
          <li>
         	 <a href="../member/insert" class="nav-link px-2 link-body-emphasis">회원가입</a>
          </li>
          <!-- 게시판 -->
          <li>
          	<a href="../board/list" class="nav-link px-2 link-body-emphasis">게시판</a>
          </li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
        </form>

        <div class="dropdown text-end">
          <a href="#" class="d-block link-body-emphasis text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="${pageContext.request.contextPath}/upload02/${profile}" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
          <ul class="dropdown-menu text-small">
            <li><a class="dropdown-item" href="#">New project...</a></li>
            <li><a class="dropdown-item" href="#">Settings</a></li>
            <li><a class="dropdown-item" href="#">Profile</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Sign out</a></li>
          </ul>
        </div>
      </div>
    </div>
  </header>
  
  
  
  <main class="main">
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  