<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Sign</title>
</head>
<body>
    <h1>학생 등록</h1>
    <form action="/student/sign" method="post">
        <p>학번 : <input type="text" name="studentNum" autofocus></p>
        <p>이름 : <input type="text" name="studentName"></p>
        <p>국어 : <input type="text" name="korean"></p>
        <p>영어 : <input type="text" name="english"></p>
        <p>수학 : <input type="text" name="math"></p>
        <input type="submit" value="등록">
        <input type="reset" value="초기화">
    </form>
</body>
</html>
