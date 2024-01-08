<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>로그인</h1>
    <form action="/member/login" method="post">
        <p>ID : <input type="text" name="memberId" placeholder="아이디를 입력하세요."></p>
        <p>PW : <input type="text" name="memberPw" placeholder="비밀번호를 입력하세요."></p>
        <input type="submit" value="로그인">
    </form>
</body>
</html>
