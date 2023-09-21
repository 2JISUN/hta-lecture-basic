<!-- page 게시판 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../include/header.jsp" %>





<div class="container">
	<!-- 간격 및 크기를 맞추기 위한 div  -->
	<div class="row d-flex justify-content-center">
		<div class="col-8">
		<h3>delete.jsp 글 삭제하기</h3>
		<br>
			<!-- 데이터를 보내주는 방식 -->
			<form action="../board/board-delete-process.jsp"
				  method="post">
				<!-- 방법01 -->  
				<%-- <input type="hidden" 
					   name="no"
					   value="<%=strNo%>"  --%> 
					   
				<!-- 방법02 -->  
				<input type="hidden" /*숨겨서 삭제하기 el문법 사용가능 */
					   name="no"
					   value="${param.no }"> 
			
				
				<!-- 비밀번호 -->
				<div class="mb-3">
				  <label for="password" class="form-label">비밀번호</label>
				  <input type="text" 
				  		 class="form-control" 
				  		 id="title" 
				  		 name="password" /*!!!*/
				  		 placeholder="비밀번호">
				</div>
				
				<!-- 버튼 -->
				<div class="d-flex justify-content-center mt5 mb5">
					<button class="btn btn-primary mx-1">삭제</button>
					<button type="reset" class="btn btn-secondary">취소</button>
				</div>
			</form>
		</div>
	</div>
</div>
	
<%@ include file="../include/footer.jsp" %>



















