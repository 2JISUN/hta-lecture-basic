<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JDBCConnect jdbcConn = new JDBCConnect();
	String userPW = request.getParameter("userPW");
	String loggedID = (String)session.getAttribute("loggedID");
	String userID = request.getParameter("userID");
	
	String sql = "delete from member where id = ? and password = ?";
	PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
	pstmt.setString(1,userID);
	pstmt.setString(2,userPW);
	int result = pstmt.executeUpdate();
	System.out.println(userPW);
	if(result>0) {
		session.invalidate();
		ScriptWriter.alertAndNext(response, "회원탈퇴 되었습니다. 꺼져", "../index/index.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "비빌번호를 확인해 주세요.");
	}
	jdbcConn.close();
%>




