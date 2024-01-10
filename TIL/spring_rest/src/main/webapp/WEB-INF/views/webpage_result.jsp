<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>RESTful 웹 서비스</title>
</head>
<body>
    <h3>RESTful 웹 서비스</h3>
    <p><% out.print(new java.util.Date()); %></p>
    <p>${title}</p>
    <%-- @RequestBody로 받은 매개변수를 출력한다.
    (받아온 데이터 형태를 확인할 수 있다.) --%>
    <%-- 데이터 형식 : name=soo&age=14&email=soo%40gmail.com
    (다중 값을 '&'로 연결한 'name=value' 형태) --%>
    <p>${result}</p>
</body>
</html>
