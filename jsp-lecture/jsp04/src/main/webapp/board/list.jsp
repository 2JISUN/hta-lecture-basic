<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 
//0.전역변수 할당
//get : request.getParameter를 사용하여 사용자가 입력한 정보를 받아옵니다.

//1. driver 찾기
//2. db연동 및 해제
JDBCConnect jdbcConn = new JDBCConnect(); //Oracle 데이터베이스에 연결을 수행
 
 

//3. db접근 > 쿼리 작성 > select > db 가져오기 > executeQuery()
//3-1. 쿼리 작성
String sql = 
"select *"+
"from board " + 
"order by regdate desc"
		;
//3-2. 쿼리 세팅(저장)
PreparedStatement pstmt = null; //Prepared : SQL 문장을 실행하기
pstmt = jdbcConn.conn.prepareStatement(sql); //prepare : PreparedStatement 객체를 생성하는 메서드
//set : pstmt.setString를 사용하여 사용자가 입력한 정보를 db에 저장합니다.


//4. db실행 > 쿼리 실행 > db 가져오기(결과 확인) : 화면에 뿌린다 > executeQuery()
ResultSet rs = null; //rs는 SQL 쿼리의 결과 집합으로 JDBC 객체임
rs = pstmt.executeQuery(); //executeQuery() 쿼리를 데이터베이스로 보내고 그 결과를 가져온다. 
 
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