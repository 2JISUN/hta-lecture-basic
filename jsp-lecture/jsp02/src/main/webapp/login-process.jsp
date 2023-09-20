<%@page import="util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	String saveID = request.getParameter("saveID");
	//System.out.println(saveID);
	if(userID.equals("2JISUN") && userPW.equals("1234")) {
		if(saveID!=null && saveID.equals("yes")) {
			// 여기다가 쿠키 설정
			CookieManager.createCookie(response, "loginID", userID, 60*60*24*365);
		} else {
			// 여기다가 쿠키 삭제
			CookieManager.deleteCookie(response, "loginID");
			
		}
		out.println("<script>alert('로그인 성공'); location.href='login-main.jsp';</script>");
	} else {
		out.println("<script>alert('로그인 실패'); history.back();</script>");
	}
%>