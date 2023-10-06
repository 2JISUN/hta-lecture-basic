<!-- page 로그인 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>


<div class="form-signin w-100 m-auto">
	<form action="../member/login-process" 
			method="post" 
			id="joinForm"
			name="member">
			
		<!-- 아이디 입력, 쿠키 삽입 -->
		<div class="form-floating">
			<input type="text" 
				   name="userID" 
				   class="form-control" 
				   id="userID" 
				   value="${cookie.saveIDCookie.value}" 
				   placeholder="아이디"> 
			<label for="userID">아이디 입력</label>
		</div>
		
		<!-- 비밀번호 입력 -->
		<div class="form-floating">
			<input type="password" 
				   name="userPW" 
				   class="form-control" 
				   id="userPW"
				   placeholder="비밀번호"> 
		   <label for="userPW">비밀번호 입력</label>
		</div>
		
		<!-- 쿠키로 아이디 기억하기 -->
		<div class="form-check text-start my-3">
			<input class="form-check-input" 
				   type="checkbox" 
				   value="rememberMe"
				   id="flexCheckDefault" 
				   name="saveID" 
				   <c:if test="${not empty cookie.saveIDCookie}">checked</c:if>> 
			<label class="form-check-label" for="flexCheckDefault"> 아이디 기억하기(쿠키) </label>
		</div>
		
		<!-- 로그인 버튼 -->
		<button class="btn btn-primary w-100 py-2" type="submit">로그인</button>
		<p class="mt-5 mb-3 text-body-secondary">© 2017–2023</p>

	</form>
</div>

<%@ include file="../include/footer.jsp"%>