<%@page import="java.sql.ResultSet"%>
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
	
	String sql = "select * from member where id = ? and password = ?";
	PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
	pstmt.setString(1,userID);
	pstmt.setString(2,userPW);
	ResultSet rs = pstmt.executeQuery();
	System.out.println(userPW);
	if(rs.next()) {
		request.setAttribute("userName", rs.getString("name"));
		request.setAttribute("postCode", rs.getString("postcode"));
		request.setAttribute("address", rs.getString("address"));
		request.setAttribute("addressDetail", rs.getString("addressdetail"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("../member/modify-form.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("../member/modify-form.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "비밀번호 확인해 주세요.");
	}
	jdbcConn.close();
%>




