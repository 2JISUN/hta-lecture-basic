<!-- process 로그아웃 -->
<%@page import="util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	/* 로그아웃 */
	//session.removeAttribute("loggedName");
	CookieManager.deleteCookie(response, "visitedCookie"); //쿠키삭제
	session.invalidate();
	response.sendRedirect("../index/index.jsp");

%>