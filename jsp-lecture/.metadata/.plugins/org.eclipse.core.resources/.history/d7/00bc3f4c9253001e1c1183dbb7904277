<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String userPW = request.getParameter("userPW");
	String userID = request.getParameter("userID");

	

	//1. driver찾기...
	String driver = "oracle.jdbc.OracleDriver";
	Class.forName(driver);
	// 17  ojdbc11, 11 ojdbc9
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jjang051";
	String pw = "1234";
	
	Connection conn = DriverManager.getConnection(url, id, pw);
	System.out.println("db연결 성공");
	// 쿼리쓰고 결과값 받아오기....
	// 1. 쿼리문 처리 메서드
	// 2. 결과값 받아오기  select 를 제외하고 나머지는 정수
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from test where id = ? and password = ? ";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,userID);
	pstmt.setString(2,userPW);
	rs = pstmt.executeQuery();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>no</th>
				<th>id</th>
				<th>password</th>
				<th>age</th>
				<th>regdate</th>
				
			</tr>
		</thead>
		<tbody>
		<%
			if(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getInt("no")+"</td>");
				out.println("<td>"+rs.getString("id")+"</td>");
				out.println("<td>"+rs.getString("password")+"</td>");
				out.println("<td>"+rs.getInt("age")+"</td>");
				out.println("<td>"+rs.getString("regdate")+"</td>");
				out.println("</tr>");
			} else {
				ScriptWriter.alertAndBack(response, "비밀번호 확인해 주세요");
			}
		%>
		</tbody>
	</table>
</body>
</html>