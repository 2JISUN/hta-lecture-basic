<!-- page 회원정보수정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<%@ include file="../include/header.jsp"%>


<div class="info w-100 m-auto">

	<form 
			action="../member/modify-confirm" 
			method="post">
		<input 
				type="hidden" 
				name="userID" 
				value="${loggedID }"> 
		<table class="table striped">
			<tbody>
				<tr>
					<th scope="row">아이디</th>
					<%-- <td><input type="text" class="form-control" name="userID" value="<%= loggedID %>" readonly></td> --%>
					<td>${loggedID }</td> <!-- sessionScope 생략가능 > 알아서 찾아감 -->
				</tr>
				<tr>
					<th scope="row">비밀번호</th>
					<td>
						<div class="mb-3">
							<input type="password" 
								   class="form-control" 
								   id="userPW" 
								   placeholder="user password" 
								   name="userPW" />
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		
		<div class="d-flex justify-content-center">
			<button class="btn btn-primary">회원정보수정</button>
			<a href="javascript:history.back();" class="btn btn-secondary mx-1">돌아가기</a>
		</div>
	</form>
</div>


<%@ include file="../include/footer.jsp"%>















