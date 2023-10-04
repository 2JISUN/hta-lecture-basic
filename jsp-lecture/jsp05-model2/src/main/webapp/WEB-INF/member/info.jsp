<%@ page language="java" 
		contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8"%>
		
		
<%@ include file="../include/header.jsp"%>

s
<div class="info w-100 m-auto">
	<table class="table striped">
		<tbody>
			<c:choose>
			<c:when test="${not empty infoMember.profile}">
			<tr>
				<th scope="row">프로필</th>
				<td>
					<img src="${pageContext.request.contextPath }/upload/${infoMember.profile}" 
						 class="profile">
				</td>  
			</tr>
			</c:when>
			<c:otherwise>
			<tr>
				<th scope="row">프로필</th>
				<td>
					<img src="../images/user.png" 
						 class="profile">
				</td>  
			</tr>
			</c:otherwise>
			</c:choose>
			
			<tr>
				<th scope="row">아이디</th>
				<td>${loggedID }</td>  <!-- 아이디와 이름은 세션에 있음 -->
			</tr>
			<tr>
				<th scope="row">비밀번호</th>
				<td>${infoMember.password }</td>
			</tr>
			<tr>
				<th scope="row">이름</th>
				<td>${loggedName}</td> <!-- 아이디와 이름은 세션에 있음 -->
			</tr>
			<tr>
				<th scope="row">우편번호</th>
				<td>${infoMember.postcode}</td>
			</tr>
			<tr>
				<th scope="row">주소</th>
				<td>${infoMember.address}</td>
			</tr>
			<tr>
				<th scope="row">가입날짜</th>
				<td>${infoMember.regdate}</td>
			</tr>
		</tbody>
	</table>
	
	<div class="d-flex justify-content-center">
		<a href="../member/delete" class="btn btn-primary">회원탈퇴</a>
		<a href="../member/modify" class="btn btn-secondary mx-1">정보수정</a>
	</div>
</div>


<%@ include file="../include/footer.jsp"%>

