<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	JDBCConnect jdbcConn = new JDBCConnect();
	String sql = "select * from member where id = ? and password = ?";
	PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
	pstmt.setString(1, userID);
	pstmt.setString(2, userPW);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) {
		//pageContext> request > session > application		
		session.setAttribute("loggedID", rs.getString("id"));
		session.setAttribute("loggedName", rs.getString("name"));
		response.sendRedirect("../index/index.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "아이디 패스워드 확인해 주세요.");
	}
	jdbcConn.close();
%>









