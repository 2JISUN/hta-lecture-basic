<!-- page 내정보 -->
<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

//0.전역변수 할당
//get : request.getParameter를 사용하여 사용자가 입력한 정보를 받아옵니다.
String userID = request.getParameter("userID");


//1. driver 찾기
//2. db연동
JDBCConnect jdbcConn = new JDBCConnect();  //Oracle 데이터베이스에 연결을 수행


//3. db접근 > 쿼리 작성 > INSERT, UPDATE, DELETE > db 업데이트 > executeUpdate()
//3. db접근 > 쿼리 작성 > SELECT > db 가져오기 > executeQuery()
//3-1. 쿼리 작성
String sql = "select * from member where id = ?";
//3-2. 쿼리 세팅(저장)
PreparedStatement pstmt = null; //Prepared : SQL 문장을 실행하기
pstmt = jdbcConn.conn.prepareStatement(sql); //prepare : PreparedStatement 객체를 생성하는 메서드
//set : pstmt.setString를 사용하여 사용자가 입력한 정보를 db에 저장합니다.
pstmt.setString(1, userID);



//4. db실행 > 쿼리 실행 > db 업데이트 > executeUpdate()
//4. db실행 > 쿼리 실행 > db 가져오기(결과 확인) : 화면에 뿌린다 > executeQuery()
//result는 데이터베이스 조작 작업을 실행한 결과로서, 영향을 받는 <레코드 수>를 나타내는 정수입니다. 
ResultSet rs = null; //rs는 SQL 쿼리의 결과 집합으로 JDBC 객체임
rs = pstmt.executeQuery(); //executeQuery() 쿼리를 데이터베이스로 보내고 그 결과를 가져온다. 
	


//5. 조건 >  
String userPW = null;
String userName = null;
int postCode = 0;
String address = null;
String regDate = null;
if (rs.next()) {
	userPW = rs.getString("password");
	userName = rs.getString("name");
	postCode = rs.getInt("postCode");
	address = rs.getString("address");
	regDate = rs.getString("regDate");
} else {
	ScriptWriter.alertAndBack(response, "서버 오류입니다. 잠시 후 다시 시도해주세요.");
}
jdbcConn.close();
%>


<%@ include file="../include/header.jsp"%>
<div class="info w-100 m-auto">
	<table class="table table-striped">
		<tbody>
			<tr>
				<th scope="row">ID</th>
				<td><%=userID%></td>
			</tr>
			<tr>
				<th scope="row">password</th>
				<td><%=userPW%></td>
			</tr>
			<tr>
				<th scope="row">name</th>
				<td><%=userName%></td>
			</tr>
			<tr>
				<th scope="row">post code</th>
				<td><%=postCode%></td>
			</tr>
			<tr>
				<th scope="row">address</th>
				<td><%=address%></td>
			</tr>
			<tr>
				<th scope="row">regDate</th>
				<td><%=regDate%></td>
			</tr>
		</tbody>
	</table>
	
	<div class="d-flex justify-content-center">
		<a href="../member/delete.jsp" class="btn btn-primary">회원탈퇴</a>
		<a href="../member/modify.jsp" class="btn btn-secondary mx-1">정보수정</a>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>















