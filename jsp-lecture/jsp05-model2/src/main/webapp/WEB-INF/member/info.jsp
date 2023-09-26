<%@ page language="java" 
		contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8"%>
		
		
<%@ include file="../include/header.jsp"%>


<div class="info w-100 m-auto">
	<table class="table striped">
		<tbody>
			<tr>
				<th scope="row">ID</th>
				<td>${loggedID }</td>  <!-- 아이디와 이름은 세션에 있음 -->
			</tr>
			<tr>
				<th scope="row">password</th>
				<td>${infoMember.password }</td>
			</tr>
			<tr>
				<th scope="row">name</th>
				<td>${loggedName}</td> <!-- 아이디와 이름은 세션에 있음 -->
			</tr>
			<tr>
				<th scope="row">post code</th>
				<td>${infoMember.postcode }</td>
			</tr>
			<tr>
				<th scope="row">address</th>
				<td>${infoMember.address }</td>
			</tr>
			<tr>
				<th scope="row">regdate</th>
				<td>${infoMember.regdate }</td>
			</tr>
		</tbody>
	</table>
	
	<div class="d-flex justify-content-center">
		<a href="../member/delete" class="btn btn-primary">회원탈퇴</a>
		<a href="../member/modify" class="btn btn-secondary mx-1">정보수정</a>
	</div>
</div>


<%@ include file="../include/footer.jsp"%>

