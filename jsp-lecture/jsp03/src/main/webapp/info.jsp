<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>고객 인포 테이블</title>
    <style>
        h1 {
			margin: auto;
            left:50%;
        }
        table {
            border-collapse: collapse;
            width: 50%;
            margin: auto;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        button {
            position:absolute;
            left:50%;
        }
    </style>
</head>
<body>
<%
    String userID = request.getParameter("id");

    //1. driver 찾기
    String driver = "oracle.jdbc.OracleDriver";
    Class.forName(driver);

    //2. url
    // 자바17 = 오라클11
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String id = "jisun";
    String pw = "1234";

    Connection conn = DriverManager.getConnection(url, id, pw);
    System.out.println("db연결 성공");

    //3. 조회 : 쿼리 작성 + 결과값 받아오기
    //3-1. 쿼리문 처리 메서드
    //3-2. 결과값 받아오기 select 를 제외하고 나머지는 정수 0
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "select * from test where id = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, userID);
    rs = pstmt.executeQuery();
%>

	<h1>고객 인포 테이블</h1>
	<br>
	<br>
	<table>
	    <tbody>
	        <tr>
	            <th>아이디</th>
	            <td><%= userID %></td>
	        </tr>
	        <tr>
	            <th>password</th>
	            <td><input type="password" name="userPW"></td>
	        </tr>
	    </tbody>
	</table>
	<br>
	<br>
    <form action="unregister.jsp" method="post">
    <input type="hidden" name="userID" value="<%= userID %>" readonly>
    <div>
        <label>
            <span>비밀번호 확인</span>
            <input type="password" name="confirmPW">
        </label>
    </div>
    <button type="submit">회원탈퇴</button>
</form>
	</body>
</html>