<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Main</title>
    <style>
        a, table {
            display: inline;
        }
    </style>
</head>
<body>
    <h1>학점 관리</h1>
    <p><a href="/member/login">로그인</a></p>
    <a href="/student/sign">학생 등록</a>
    <table>
        <tr>
            <th>학번</th>
            <th>이름</th>
        </tr>
        <c:forEach items="${studentList}" var="studentList">
            <tr>
                <td><a href="/student/update?studentNum=${studentList.studentNum}">${studentList.studentNum}</a></td>
                <td>${studentList.studentName}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
