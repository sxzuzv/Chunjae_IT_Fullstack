<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>RESTful 웹 서비스</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%-- <c:url .. > : 가변적인 url 설정이 가능하다. --%>
<%-- data : 클라이언트와 서버 사이의 데이터 전달은 문자열만 가능하다.
그러므로 JSON.stringify()를 통해 JSON을 문자열 형태로 전송한다.
데이터를 전송받은 이후에는 문자열을 JSON으로 되돌리면 된다. --%>
<script>
  var obj = {"name" : "kim",  "age" : 30};
  function test(){
    $.ajax({
      url : "<c:url value="/test"/>",
      type : "post",
      data : JSON.stringify(obj),
      dataType : "json",
      contentType : "application/json",

      success : function(data){
        alert("성공");
      },
      error:function(errorThrown){

        alert("실패");
      }
    });
  }

</script>
<body>
  <h3>RESTful 웹 서비스</h3>
  <button onclick="test()" type="button">실행하기</button>
</body>
<html>