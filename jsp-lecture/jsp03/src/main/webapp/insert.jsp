<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body>
    <form action="insert-process.jsp" method="post">
        <div>
            <label>
                <span>아이디</span>
                <input type="text" name="userID">
            </label>
        </div>
        <div>
            <label>
                <span>패스워드</span>
                <input type="password" name="userPW">
            </label>
        </div>
        <div>
            <label>
                <span>나이</span>
                <input type="text" name="userAge">
            </label>
        </div>
        <div>
            <label>
                <span>출생년도</span>
                <select name="userBirth"> 
                    <% 

                    // 출생년도 옵션 생성
                    for (int year = 1900; year <= 2023; year++) {
                    %>
                    <option value="<%= year %>"><%= year %></option>
                    <% } %>
                </select>
            </label>
        </div>
        <button type="submit">회원가입</button>
    </form>
</body>
</html>
