<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>구구단 출력</title>
</head>
<body>
    <%
        String danStr = request.getParameter("dan");
        int dan = 2; // 기본값으로 2단을 설정

        if (danStr != null && !danStr.isEmpty()) {
            try {
                dan = Integer.parseInt(danStr);
            } catch (NumberFormatException e) {
                // 예외 처리: 숫자로 변환할 수 없는 경우 기본값인 2단을 사용
            }
        }
    %>

    <h2><%= dan %>단 출력</h2>
    <ul>
        <% for (int i = 1; i <= 9; i++) { %>
            <li><%= dan %> X <%= i %> = <%= dan * i %></li>
        <% } %>
    </ul>
</body>
</html>
