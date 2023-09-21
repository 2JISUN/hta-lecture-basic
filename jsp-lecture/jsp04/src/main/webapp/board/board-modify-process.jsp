<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="common.JDBCConnect" %>
<%@ page import="util.ScriptWriter" %>

<%


//0.전역변수 할당
//get : request.getParameter를 사용하여 사용자가 입력한 정보를 받아옵니다.
String password = request.getParameter("password");
String loggedID = (String)session.getAttribute("loggedID"); //데이터 가져오기 방법1
String ID = request.getParameter("ID"); 			//데이터 가져오기 방법2


//1. driver 찾기
//2. db연동
JDBCConnect jdbcConn = new JDBCConnect(); //Oracle 데이터베이스에 연결을 수행

//3. db접근 > 쿼리 작성 > INSERT, UPDATE, DELETE > db 업데이트 > executeUpdate()
//3. db접근 > 쿼리 작성 > SELECT > db 가져오기 > executeQuery()
//3-1. 쿼리 작성
	String sql = "select * from board where id = ? and password = ?";

	//3-2. 쿼리 세팅(저장)
	PreparedStatement pstmt = null; //Prepared : SQL 문장을 실행하기
	pstmt = jdbcConn.conn.prepareStatement(sql); //prepare : PreparedStatement 객체를 생성하는 메서드
	
	//set : pstmt.setString를 사용하여 사용자가 입력한 정보를 db에 저장합니다.
	pstmt.setString(1,loggedID);
	pstmt.setString(2,password);
	
	
	//4. db실행 > 쿼리 실행 > db 업데이트 > executeUpdate()
	//4. db실행 > 쿼리 실행 > db 가져오기(결과 확인) : 화면에 뿌린다 > executeQuery()
	//result는 데이터베이스 조작 작업을 실행한 결과로서, 영향을 받는 <레코드 수>를 나타내는 정수입니다. 
ResultSet rs = null; //rs는 SQL 쿼리의 결과 집합으로 JDBC 객체임
rs = pstmt.executeQuery(); //executeQuery() 쿼리를 데이터베이스로 보내고 그 결과를 가져온다. 
	System.out.println(password);
		
	
	
	//5. 조건 > 비밀번호 일치하면 수정가능
		if(rs.next()) {
			// 글쓰기 성공
			System.out.println("입력 성공");
			ScriptWriter.alertAndNext(response, "글 수정하러 가기", "../board/update.jsp");
			//response.sendRedirect("../member/modify-form.jsp");
		} else {
			ScriptWriter.alertAndBack(response, "비밀번호 확인해 주세요.");
		}
		// 데이터베이스 연결 종료
		jdbcConn.close();
	




%>