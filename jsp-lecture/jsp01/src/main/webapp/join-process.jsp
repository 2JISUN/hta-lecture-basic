<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
    String userID = request.getParameter("userID");
    String userPW = request.getParameter("userPW");
    String userName = request.getParameter("userName");
    String userAddress = request.getParameter("userAddress");
    String userZipcode = request.getParameter("userZipcode");
    String userEmail = request.getParameter("userEmail");
    String userTel = request.getParameter("userTel");
    String userbirth = request.getParameter("userbirth");
    String agree = request.getParameter("agree");

    if (userID == null || userID.isEmpty() || userPW == null || userPW.isEmpty() || userName == null || userName.isEmpty()) {
        // 필수 필드가 누락된 경우 경고 처리
        out.println("<script>alert('필수 항목을 모두 입력하세요.'); history.back();</script>");
    } else if (agree == null) {
        // 개인정보 동의 체크 안 된 경우 경고 처리
        out.println("<script>alert('개인정보 동의를 체크하세요.'); history.back();</script>");
    } else {
        // 모든 조건을 만족하면 세션에 userName 설정
        session.setAttribute("userName", userName);
        response.sendRedirect("join-success.jsp");
    }
%>
