<%@ page import="util.ScriptWriter" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 확인 결과</title>
</head>
<body>
<%
	//전역변수 할당
    String userPW = request.getParameter("userPW");
    String userID = request.getParameter("userID");
    
    //1. driver 찾기
    String driver = "oracle.jdbc.OracleDriver";
	Class.forName(driver);
	
	//2-1. db 접근
	// 자바17 = 오라클11
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String id = "jisun";
    String pw = "1234";
    
    //2-2. db 연동
    Connection conn = DriverManager.getConnection(url, id, pw);
	System.out.println("db연결 성공");
	
	//3. 조회 : 쿼리 작성 + 결과값 받아오기
	//3-1. 쿼리문 처리 메서드
	//3-2. 결과값 받아오기 select 를 제외하고 나머지는 정수 0
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from test where id = ? and password = ?";
	pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, userID);
    pstmt.setString(2, userPW);
	rs = pstmt.executeQuery();

    if (rs.next()) {
        // 일치하는 아이디와 비밀번호를 찾았을 때
        // 여기에 아이디를 데이터베이스에서 삭제하는 로직을 추가하세요.
        // 삭제 로직 예시:
        String deleteSQL = "delete from test where id = ?";
        pstmt = conn.prepareStatement(deleteSQL);
        pstmt.setString(1, userID);
        pstmt.executeUpdate();

        // 아이디 삭제 후 메시지 표시
        ScriptWriter.alertAndRedirect(response, "아이디가 삭제되었습니다.", "list.jsp");
    } else {
        // 아이디와 비밀번호가 일치하지 않을 때
        ScriptWriter.alertAndRedirect(response, "비밀번호 확인해 주세요", "list.jsp");
    }

%>
</body>
</html>
