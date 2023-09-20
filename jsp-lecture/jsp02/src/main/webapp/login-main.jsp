<%@page import="util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	Cookie cookies[] = request.getCookies();
	String loginID = "";
	String isCheck = "";
	if(cookies!=null) {
		for(Cookie c : cookies) {
			if(c.getName().equals("loginID")) {
				loginID =  c.getValue();
				isCheck="checked";
			}
		}
	}
	*/
	String loginID = CookieManager.readCookie(request, "loginID");
	//String isCheck = loginID.equals("") ? "" : "checked";
	String isCheck = "";
	if(!loginID.equals("")) {
		isCheck="checked";
	} 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>로그인</h2>
		<form action="login-process.jsp" method="post">
			<div>
				<label><span>아이디</span><input type="text" name="userID" value="<%= loginID %>"></label>
				<label><span>아이디 저장</span><input type="checkbox" name="saveID" <%= isCheck %> value="yes"></label>
			</div>
			<div><label><span>패스워드</span><input type="password" name="userPW"></label></div>
			<button>로그인</button>
		</form>
	</div>
</body>
</html>