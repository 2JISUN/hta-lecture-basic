<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<div class="row  d-flex justify-content-center">
		<div class="col-10">
			<h2 class="mb-5 mt-5">글 목록</h2>
			<c:choose>
				<c:when test="${boardSize eq 0 }">
					<p>등록된 글이 없습니다.</p>
				</c:when>
				<c:otherwise>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">no</th>
								<th scope="col">title</th>
								<th scope="col">name</th>
								<th scope="col">date</th>
								<th scope="col">hit</th>
							</tr>
						</thead>
						<tbody>
							<!-- 사랑이가 알고 있었는데 안가르쳐 줬음... -->
							<c:forEach items="${boardList}" 
										var="board" 
										varStatus="status"
										begin="0">
								<tr>
									<td>${status.index + 1 }</td>
									<td><a href="../board/view?no=${board.no }">${board.title }</a></td>
									<td>${board.name }</td>
									<td>${board.regdate }</td>
									<td>${board.hit }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>

			<div class="d-flex justify-content-center mt-5">
				<a href="../board/write" class="btn btn-primary">글쓰기</a>
			</div>


			<form action="../board/board-search-process.jsp">
				<select name="searchItem">
					<option value="title">제목</option>
					<option value="name">글쓴이</option>
					<option value="content">내용</option>
					<option value="all">싹다</option>

				</select> 
				<input type="text" name="searchWord">
				<button>검색</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>