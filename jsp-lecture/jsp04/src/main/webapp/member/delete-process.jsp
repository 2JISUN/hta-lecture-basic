<!-- process 회원탈퇴 -->

<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//0.전역변수 할당
	//get : request.getParameter를 사용하여 사용자가 입력한 정보를 받아옵니다.
	String userPW = request.getParameter("userPW");
	String loggedID = (String)session.getAttribute("loggedID");
	String userID = request.getParameter("userID");
	
	//1. driver 찾기
	//2. db연동
	JDBCConnect jdbcConn = new JDBCConnect();
	
	//3. db접근 > 쿼리 작성 > INSERT, UPDATE, DELETE > db 업데이트 > executeUpdate()
	//3. db접근 > 쿼리 작성 > SELECT > db 가져오기 > executeQuery()
	//3-1. 쿼리 작성
	String sql = "delete from member where id = ? and password = ?";
	
	//3-2. 쿼리 세팅(저장)
	PreparedStatement pstmt = null; //Prepared : SQL 문장을 실행하기
	pstmt = jdbcConn.conn.prepareStatement(sql); //prepare : PreparedStatement 객체를 생성하는 메서드
		
	//set : pstmt.setString를 사용하여 사용자가 입력한 정보를 db에 저장합니다.
	pstmt.setString(1,userID);
	pstmt.setString(2,userPW);
	
	//4. db실행 > 쿼리 실행 > db 업데이트 > executeUpdate()
	//4. db실행 > 쿼리 실행 > db 가져오기(결과 확인) : 화면에 뿌린다 > executeQuery()
	//result는 데이터베이스 조작 작업을 실행한 결과로서, 영향을 받는 <레코드 수>를 나타내는 정수입니다. 
	int result = pstmt.executeUpdate(); //executeUpdate() 레코드 수를 반환합니다.
	System.out.println(userPW);
	
	//5. 조건 > 회원탈퇴 성공여부
	if(result>0) {
		session.invalidate();
		ScriptWriter.alertAndNext(response, "회원탈퇴 되었습니다. 꺼져", "../index/index.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "비빌번호를 확인해 주세요.");
	}
	jdbcConn.close();
	
%>




