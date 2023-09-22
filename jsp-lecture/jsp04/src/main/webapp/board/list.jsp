<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%

String strPage = request.getParameter("page");
int intPage = 1;
if(strPage==null || strPage.isEmpty()) {
	intPage=1;
} else {
	intPage = Integer.parseInt(strPage);
}

JDBCConnect jdbcConn = new JDBCConnect();
PreparedStatement pstmt = null;
String countSql = "select count(*) as total from board";  
pstmt = jdbcConn.conn.prepareStatement(countSql);
ResultSet countRs = pstmt.executeQuery();
int total = 0;
if(countRs.next()) {
	total = countRs.getInt("total"); 
}
int listPerPage = 10; // 한번에 보여지는 list 갯수
System.out.println("total==="+total+"(double)total/listPerPage"+(double)total/listPerPage+"total/listPerPage"+total/listPerPage);
int pageTotal = (int)Math.ceil((double)total/listPerPage);   // 바닥에 뿌려질 pagination의 갯수
System.out.println("pageTotal==="+pageTotal);
String sql = "SELECT * FROM " + "(SELECT rownum AS num, b01.* from " + "(SELECT * FROM board ORDER BY NO DESC) b01"
		+ ")" + "WHERE num >= ? AND num <= ?";
pstmt = jdbcConn.conn.prepareStatement(sql);
pstmt.setInt(1,(intPage-1)*listPerPage+1);
pstmt.setInt(2,intPage*listPerPage);

ResultSet rs = pstmt.executeQuery();
%>
    
    
<%@ include file="../include/header.jsp" %>

<div class="container">

	<!-- 간격 및 크기를 맞추기 위한 div  -->
	<div class="row d-flex justify-content-center">
		<div class="col-10">
		<h3>게시판 글 목록</h3>
		<br>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">no</th>
			      <th scope="col">title</th>
			      <th scope="col">name</th>
			      <th scope="col">regdate</th>
			      <th scope="col">hit</th>
			      <th scope="col">
			      	<input type="checkbox" 
			      		   id="checkAll">
			      </th>
			    </tr>
			  </thead>
			  
			  <tbody>
			  	<% while(rs.next()){ %>
			  	<tr>
			      <td scope="col"><%=rs.getInt("no") %></td>
			      <td scope="col">
				      <a href="../board/view.jsp?no=<%=rs.getInt("no") %>">
				      	<%=rs.getString("title") %>
				      </a>
			      </td>
			      <td scope="col"><%=rs.getString("name") %></td>
			      <td scope="col"><%=rs.getString("regdate") %></td>
			      <td scope="col"><%=rs.getInt("hit") %></td>
			      <td scope="col">
			      	<input type="checkbox" 
			      		   id="checkAll">
			      </td>
			    </tr>
			    <% } %>
			  </tbody>
			</table>
			
			<!-- 페이지네이션 -->

			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item">
					<a class="page-link" href="#"
						aria-label="Previous"> 
						<span aria-hidden="true">&laquo;</span>
					</a>
					</li>
					<%for(int i=1;i<=pageTotal;i++){ %>
						<%if(i==intPage) { %>
					<li class="page-item"><a class="page-link active" href="../board/list.jsp?page=<%=i%>"><%=i %></a></li>
					<%} else { %>
					<li class="page-item"><a class="page-link" href="../board/list.jsp?page=<%=i%>"><%=i %></a></li>
					<%} %>
					<%} %>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>

			
			<!-- 버튼 -->
			<div class="d-flex justify-content-center mt-5">
				<a href="../board/list.jsp" class="btn btn-primary mx-1">목록</a>
				<a href="../board/write.jsp" class="btn btn-primary mx-1">글작성</a>
			</div>
			
			<!-- 검색기능 추가 -->
			<!-- 폼 태그 안의 태그에서 name이 중요하다 -->

			<div class="d-flex justify-content-center mt-5">
				<form action="../board/board-search-process.jsp" >
						<select name="searchItem">
							<option value="title">제목</option>
							<option value="name">글쓴이</option>
							<option value="content">내용</option>
						</select>
						<input type="text" name="searchWord" >
						<button class="btn btn-primary mx-1" >검색</button>
				</form>
			</div>
		</div>
	</div>
</div>
	
<%@ include file="../include/footer.jsp" %>