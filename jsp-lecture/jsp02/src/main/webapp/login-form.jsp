<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
</head>
<body>
    <form action="login-process.jsp" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">이메일</label>
            <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">계정정보는 타인에게 보이지 않습니다.</div>
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">비밀번호</label>
            <input type="password" class="form-control" id="exampleInputPassword1" name="password">
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember">
            <label class="form-check-label" for="exampleCheck1">로그인정보 기억하기</label>
        </div>
        <button type="submit" class="btn btn-primary">로그인</button>
    </form>
</body>
</html>
