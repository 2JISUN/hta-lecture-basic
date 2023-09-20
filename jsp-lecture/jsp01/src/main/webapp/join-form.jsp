<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <!-- Bootstrap CSS 링크 추가 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <form action="join-process.jsp" method="post">
            <div class="mb-3">
                <label for="userID" class="form-label">아이디:</label>
                <input type="text" id="userID" name="userID" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="userPW" class="form-label">비밀번호:</label>
                <input type="password" id="userPW" name="userPW" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="userName" class="form-label">이름:</label>
                <input type="text" id="userName" name="userName" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="userAddress" class="form-label">주소:</label>
                <input type="text" id="userAddress" name="userAddress" class="form-control">
            </div>
            <div class="mb-3">
                <label for="userZipcode" class="form-label">우편주소:</label>
                <input type="text" id="userZipcode" name="userZipcode" class="form-control">
            </div>
            <div class="mb-3">
                <label for="userEmail" class="form-label">이메일:</label>
                <input type="email" id="userEmail" name="userEmail" class="form-control">
            </div>
            <div class="mb-3">
                <label for="userTel" class="form-label">전화번호:</label>
                <input type="tel" id="userTel" name="userTel" class="form-control">
            </div>
            <div class="mb-3">
                <label for="userbirth" class="form-label">생일:</label>
                <input type="date" id="userbirth" name="userbirth" class="form-control">
            </div>
            <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" id="agree" name="agree">
                <label class="form-check-label" for="agree">개인정보 동의합니다</label>
            </div>
            <button type="submit" class="btn btn-primary">제출</button>
        </form>
    </div>
    <!-- Bootstrap JS 및 jQuery 스크립트 추가 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>
