<%@page import="util.CookieManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

/* 	
응답방식 : HTTP 응답의 Content-Type 헤더를 설정하는 부분 
 ①application/json > {제목:내용}
 ②text/html > 제목/내용
 ③text/plain > <h1>제목</h1>
역할 : 클라이언트에게 전송되는 데이터의 형식과 문자 인코딩을 명시적으로 지정
목적 : 이를 통해 데이터의 정확한 해석과 처리가 가능해집니다.
*/
response.setContentType("text/html; charset=utf-8");



//0.전역변수 할당
//get : request.getParameter를 사용하여 사용자가 입력한 정보를 받아옵니다.
int no = 0;

//글 번호
String strNo = request.getParameter("no");
if(strNo!=null){
	no = Integer.parseInt(strNo);
}


// 쿠키
boolean isUpdate = false;
String visitedCookieValue = CookieManager.readCookie(request,"visitedCookie");
//첫 방문시 쿠키를 생성한다
if(visitedCookieValue.isEmpty()){

	System.out.println("방문한적 없음"); 
	CookieManager.createCookie(response, "visitedCookie", strNo, 60*60*24); /* strNo : cookieValue가 핵심이다 */
//첫 방문이 아니라면 쿠키를 생성하지 않고 조건을 걸어서 판단한다.
//조건 : 글 별로 판단하기
} else {
	System.out.println("방문한적 있음");
	
	// 첫 방문이 아니고 
	// 글 방문도 처음이 아니라면 조회수를 증가시키지 않는다
	if(visitedCookieValue.contains(strNo)){
		isUpdate = false;	// 조회수 증가x
	// 첫 방문이 아니고 
	// 글 방문이 처음일 경우 조회수를 증가시킨다.
	} else {
		isUpdate = true; 	// 조회수 증가o
		CookieManager.deleteCookie(response, "visitedCookie");
		CookieManager.createCookie(response, 
								   "visitedCookie", 
								   visitedCookieValue + "/" + strNo, 
								   60*60*24);
	}
}





//1. driver 찾기
//2. db연동 및 해제
JDBCConnect jdbcConn = new JDBCConnect(); //Oracle 데이터베이스에 연결을 수행
PreparedStatement pstmt = null; //Prepared : SQL 문장을 실행하기







//3. db접근 > 쿼리 작성 > select > db 가져오기 > executeQuery()
//3-1. 쿼리 작성(순서중요)
//조회수 업데이트 시키고 쿼리

if(isUpdate){
	String updateSql = "update board set hit = hit +1 where no = ?"; //조회수 업데이트
	pstmt = jdbcConn.conn.prepareStatement(updateSql); //prepare : PreparedStatement 객체를 생성하는 메서드
	pstmt.setInt(1, no);
	pstmt.executeUpdate();
}



//3-2. 쿼리 세팅(저장)


String sql = "select * from board where no = ?"; 
pstmt = jdbcConn.conn.prepareStatement(sql); //prepare : PreparedStatement 객체를 생성하는 메서드
//set : pstmt.setString를 사용하여 사용자가 입력한 정보를 db에 저장합니다.
pstmt.setInt(1, no);
//4. db실행 > 쿼리 실행 > db 가져오기(결과 확인) : 화면에 뿌린다 > executeQuery()
ResultSet rs = null; //rs는 SQL 쿼리의 결과 집합으로 JDBC 객체임
rs = pstmt.executeQuery(); //executeQuery() 쿼리를 데이터베이스로 보내고 그 결과를 가져온다. 



%>
	
<%@ include file="../include/header.jsp" %>

<div class="container">
	<!-- 간격 및 크기를 맞추기 위한 div  -->
	<div class="row d-flex justify-content-center">
		<div class="col-8">
		<h3>view.jsp 글보기</h3>
		<br>
			<table class="table">
			<colgroup>
				<col style="width:15%">
				<col style="width:35%">
				<col style="width:15%">
				<col style="width:35%">
			</colgroup>
			
			<%if(rs.next()){ %>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3">
						<%= rs.getString("title") %>
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td colspan="3">
							<%= rs.getString("name") %>
						</td>
					</tr>
					<tr>
						<th>날짜</th>
						<td>
							<%= rs.getString("regdate") %>
						</td>
						<th>조회수</th>
						<td colspan="3" class="hit">
							<%= rs.getString("hit") %>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3" class="content">
							<%= rs.getString("content") %>
						</td>
					</tr>
				</tbody>

				</table>
				<!-- 버튼 -->
				<div class="d-flex justify-content-center mt-5">
					<a href="../board/list.jsp" class="btn btn-primary mx-1">목록</a>
					<!-- <a href="../board/write.jsp" class="btn btn-primary mx-1">글작성</a> -->
					<% if(loggedID.equals(rs.getString("id"))){ %>
						<a href="../board/delete.jsp?no=<%= rs.getInt("no") %>" 
						   class="btn btn-danger mx-1">
						   지우기
						</a>
						<a href="../board/modify.jsp?no=<%= rs.getInt("no") %>" 
						   class="btn btn-danger mx-1">
						   수정하기
						</a>
					<% } %>

				</div>
			<% } %>
		</div>
	</div>
</div>


<!-- 데이터베이스 연결 종료 --> 
<%-- <% jdbcConn.close(); %> --%>
	
<%@ include file="../include/footer.jsp" %>



















