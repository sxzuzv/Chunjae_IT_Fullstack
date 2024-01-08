<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Sign</title>
</head>
<body>
  <h1>학생 정보 등록</h1>
  <form action="/student/sign" method="post">
      <p>학번 : <input type="text" name="studentNum" placeholder="학번" autofocus></p>
      <p>이름 : <input type="text" name="studentName" placeholder="이름"></p>
      <p>국어 : <input type="text" name="korean" placeholder="국어"></p>
      <p>영어 : <input type="text" name="english" placeholder="영어"></p>
      <p>수학 : <input type="text" name="math" placeholder="수학"></p>
      <input type="submit" value="등록">
      <input type="reset" value="초기화">
  </form>
</body>
</html>
