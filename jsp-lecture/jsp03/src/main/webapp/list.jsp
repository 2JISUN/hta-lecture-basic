<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>전체 고객 리스트 테이블</title>
    <style>
        h1 {
            width: 50%;
            margin: auto;
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
    </style>
</head>
<body>   
 
<%
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
	String sql = "select * from test";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
%>
<h1>전체 고객 리스트 테이블</h1>
<br>
<br>
<table>
    <tr>
        <th>인덱스</th>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>나이</th>
        <th>출생년도</th>
        <th>가입날짜</th>
        <th><input type="checkbox" name="allCheck" id="allCheck"></th>
        
    </tr>
    <%
        while(rs.next()) {
    %>
        <tr>
            <td><%= rs.getInt("no") %></td>
            <td><a href="info.jsp?id=<%= rs.getString("id") %>"><%= rs.getString("id") %></a></td>
            <td><%= rs.getString("password") %></td>
            <td><%= rs.getInt("age") %></td>
            <td><%= rs.getInt("birthyear") %></td>
            <td><%= rs.getString("regdate") %></td>
        </tr>
    <%
        }
    %>
</table>
</body>
</html>






















