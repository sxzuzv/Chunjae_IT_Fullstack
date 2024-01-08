<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <h1>학생 정보 수정</h1>
    <form action="/student/update" method="post">
        <p>학번 : <input type="text" name="studentNum" value="${studentList.studentNum}" readonly><a href="/student/">홈</a> </p>
        <p>이름 : <input type="text" name="studentName" value="${studentList.studentName}" readonly></p>
        <p>국어 : <input type="text" name="korean" value="${studentList.korean}" autofocus></p>
        <p>영어 : <input type="text" name="english" value="${studentList.english}"></p>
        <p>수학 : <input type="text" name="math" value="${studentList.math}"></p>
        <input type="submit" value="수정">
        <input type="submit" value="삭제" onclick="deleteMember('${studentList.studentNum}')">
    </form>
</body>
<script>
    const deleteMember = (studentNum) => {
        location.href="/student/delete?studentNum="+studentNum;
    }
</script>
</html>
