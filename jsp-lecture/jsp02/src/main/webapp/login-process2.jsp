<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Process</title>
</head>
<body>
    <%
        // 사용자가 제출한 로그인 정보 가져오기
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        // 여기에서 실제 로그인 로직을 처리합니다. (예: 데이터베이스 검증)

        // 로그인이 성공하면 쿠키 생성
        if (/* 로그인 성공 조건 */) {
            if (remember != null && remember.equals("on")) {
                // 아이디를 기억할 경우 쿠키 생성
                String encodedEmail = URLEncoder.encode(email, "UTF-8");
                Cookie cookie = new Cookie("rememberedEmail", encodedEmail);
                cookie.setMaxAge(30 * 24 * 60 * 60); // 30일 동안 유지
                response.addCookie(cookie);
            }
            // 로그인 성공 메시지 또는 리다이렉션 처리
            response.sendRedirect("welcome.jsp"); // 로그인 성공 후 환영 페이지로 이동
        } else {
            // 로그인 실패 메시지 또는 리다이렉션 처리
            response.sendRedirect("login-form.jsp?error=true"); // 로그인 실패 시 다시 로그인 폼으로 이동
        }
    %>
</body>
</html>
