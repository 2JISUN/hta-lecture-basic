<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.ScriptWriter"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JDBCConnect jdbcConn = new JDBCConnect();
	String userName = request.getParameter("userName");
	String address = request.getParameter("address");
	int postCode = 0;
	if(request.getParameter("postCode")!=null) {
		postCode = Integer.parseInt(request.getParameter("postCode"));
	}
	String detailAddress = request.getParameter("detailAddress");

	String loggedID = (String)session.getAttribute("loggedID");
	
	
	String sql = "update member set  name = ?, postcode = ?, address = ?, addressdetail = ? "+
				 " where id = ?";
	PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
	pstmt.setString(1,userName);
	pstmt.setInt(2,postCode);
	pstmt.setString(3,address);
	pstmt.setString(4,detailAddress);
	pstmt.setString(5,loggedID);
	
	int result = pstmt.executeUpdate();
	if(result>0) {
		session.setAttribute("loggedName", userName);
		ScriptWriter.alertAndNext(response, "회원정보 변경되었습니다.", "../index/index.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "비빌번호를 확인해 주세요.");
	}
	jdbcConn.close();
%>