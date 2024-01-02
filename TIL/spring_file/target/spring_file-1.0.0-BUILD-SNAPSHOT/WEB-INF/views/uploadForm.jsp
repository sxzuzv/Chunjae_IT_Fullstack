<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UPLOADFORM</title>
</head>
<body>
<!-- 실제 전송은 uploadFormAction 경로를 이용하여 처리한다. -->
<!-- enctype 속성값은 'multipart/form-data'로 지정해야 한다. -->
<!-- <input type='file'>을 사용할 경우, 하나의 <input> 태그로 한꺼번에 여러 개의 파일을 업로드할 수 있다. -->
<form action="uploadFormAction" method="post" enctype="multipart/form-data">
    <input type='file' name='uploadFile' multiple>
    <button>Submit</button>
</form>
</body>
</html>
