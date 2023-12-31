<!-- process 로그인 -->

<%@page import="util.CookieManager"%>
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
	String userPW = request.getParameter("userPW");
	String saveID = request.getParameter("saveID"); //쿠키
	
	System.out.println(saveID);
	
	//1. driver 찾기
	//2. db연동 및 해제
	JDBCConnect jdbcConn = new JDBCConnect();  //Oracle 데이터베이스에 연결을 수행
	
	//3. db접근 > 쿼리 작성 > select > db 가져오기 > executeQuery()
	//3-1. 쿼리 작성
	String sql = "select * from member where id = ? and password = ?";
	//3-2. 쿼리 세팅(저장)
	PreparedStatement pstmt = null; //Prepared : SQL 문장을 실행하기
	pstmt = jdbcConn.conn.prepareStatement(sql); //prepare : PreparedStatement 객체를 생성하는 메서드
	//set : pstmt.setString를 사용하여 사용자가 입력한 정보를 db에 저장합니다.
	pstmt.setString(1, userID);
	pstmt.setString(2, userPW);
	
	//4. db실행 > 쿼리 실행 > db 가져오기(결과 확인) : 화면에 뿌린다 > executeQuery()
	ResultSet rs = null; //rs는 SQL 쿼리의 결과 집합으로 JDBC 객체임
	rs = pstmt.executeQuery(); //executeQuery() 쿼리를 데이터베이스로 보내고 그 결과를 가져온다. 
	
	//5. 조건 >  하나라도 있으면 로그인
	if(rs.next()) {
		//로그인 정보 저장 : pageContext> request > session > application		
		session.setAttribute("loggedID", rs.getString("id"));
		session.setAttribute("loggedName", rs.getString("name"));
		// 쿠키 설정
		if(saveID!=null){
			if(saveID.equals("rememberMe")){
				CookieManager.createCookie(response, "saveIDCookie", userID, 60*60*24*365);
			} else {
				CookieManager.deleteCookie(response, "saveIDCookie");
			}
		} else {
			CookieManager.deleteCookie(response, "saveIDCookie");
		}
		response.sendRedirect("../index/index.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "아이디 패스워드 확인해 주세요.");
	}
	jdbcConn.close();
%>









