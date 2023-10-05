<!-- page 게시판 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>


<div class="container">
	<!-- 간격 및 크기를 맞추기 위한 div  -->
	<div class="row d-flex justify-content-center">
		<div class="col-8">
		<h3>게시판 글쓰기</h3>
		<br>
			<!-- 데이터를 보내주는 방식 -->
			<form action="../board/modify-confirm-process"
				  method="post">
				  
				<!-- 히든설정 -->
				<input type="hidden"
					   name="loggedID"
					   value="${loggedID }">
				<input type="hidden"
					   name="loggedName"
					   value="${loggedName }">
				<input type="hidden" 
					   name="no" 
					   value="${modifyBoard.no }">
			
				<!-- 제목 -->
				<div class="mb-3">
				  <label for="title" class="form-label">제목</label>
				  <input type="text" 
				  		 class="form-control" 
				  		 id="title" 
				  		 name="title" 
				  		 placeholder="제목을 쓰세요"
				  		 value="${modifyBoard.title }">
				</div>
				
				<!-- 내용 -->
				<div class="mb-3">
				  <label for="content" class="form-label">내용</label>
				  <textarea class="form-control" 
					  		id="contenet" 
					  		name="content" 
					  		rows="8">
					  		${modifyBoard.content }
				  </textarea>
				</div>

				
				<!-- 버튼 -->
				<div class="d-flex justify-content-center mt5 mb5">
					<button class="btn btn-primary">수정완료</button>
					<button class="btn btn-secondary">취소</button>
				</div>
			</form>
		</div>
	</div>
</div>



<!-- 외부라이브러리인 ckfinder로 게시판 생성 -->
<!-- <script src="../js/ckeditor.js"></script> -->
<script src="https://cdn.ckeditor.com/ckeditor5/39.0.2/classic/ckeditor.js"></script>
<!-- 이미지 삽입을 위해서는 -->
<script>
ClassicEditor
    .create( document.querySelector( '#contenet' ),{
    	ckfinder:{
    		uploadUrl:"../board/upload"
    	}
    } )
    .catch( error => {
        console.error( error );
    } );
</script>


<%@ include file="../include/footer.jsp" %>