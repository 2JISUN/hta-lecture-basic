<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String today = request.getParameter("today");
	System.out.println("today==="+today);
	if(today!=null && today.equals("1")){
		Cookie cookie = new Cookie("popupClose","off");
		cookie.setPath(request.getContextPath()); //jsp02에 저장
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
	}
	
%>
    