<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	String userName = request.getParameter("userName");
	if(userID.equals("jjang051") && userPW.equals("1234")) {
		session.setAttribute("userName", userName);
		response.sendRedirect("login-success.jsp");
	} else {
		out.println("<script> alert('아이디 패스워드 확인해 주세요');history.back();</script>");
	}


%>