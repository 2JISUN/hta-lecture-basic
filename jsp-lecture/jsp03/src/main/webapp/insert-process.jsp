<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	String userAge = request.getParameter("userAge"); // 사용자의 나이를 요청 파라미터에서 읽어옴
	int userBirth = Integer.parseInt(request.getParameter("userBirth")); // 파라미터를 정수로 파싱
	
	// db에 집어넣기
	//1. driver 찾기
	String driver = "oracle.jdbc.OracleDriver";
	Class.forName(driver);
	
	//2. url
	// 자바17 = 오라클11
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String id = "jisun";
    String pw = "1234";
	Connection conn =  DriverManager.getConnection(url, id, pw);
	
	PreparedStatement pstmt = null;
	
	 // 시퀀스를 사용하여 NO 자동 생성
    String sql = "insert into test values(NO_seq.nextval, ?, ?, ?, ?, sysdate)";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, userID);
    pstmt.setString(2, userPW);
    pstmt.setString(3, userAge);
    pstmt.setInt(4, userBirth);
    
    int result = pstmt.executeUpdate();
    
    if (result > 0) { // Row 증가
        ScriptWriter.alertAndNext(response, "회원가입 성공", "list.jsp");
    } else {
        ScriptWriter.alertAndBack(response, "회원가입 실패");
    }
%>





























