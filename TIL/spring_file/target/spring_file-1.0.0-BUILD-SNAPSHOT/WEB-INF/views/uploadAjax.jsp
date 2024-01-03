<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <style>
    .uploadResult {
      width: 100%;
      background-color: gray;
    }

    .uploadResult ul {
      display: flex;
      flex-flow: row;
      justify-content: center;
      align-items: center;
    }

    .uploadResult ul li {
      list-style: none;
      padding: 10px;
      align-content: center;
      text-align: center;
    }

    .uploadResult ul li img {
      width: 100px;
    }
    .uploadResult ui li span{
      color:white;
    }
    .bigPictureWrapper {
      position: absolute;
      display: none;
      justify-content: center;
      align-items: center;
      top:0%;
      width:100%;
      height:100%;
      background-color: gray;
      z-index: 100;
    }

    .bigPicture {
      position: relative;
      display:flex;
      justify-content: center;
      align-items: center;
    }
    .bigPicture img{
      width: 600px;
    }
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<body>
<h1>Upload with Ajax</h1>


<div class='uploadDiv'>
  <input type='file' name='uploadFile' multiple>
</div>

<div class='uploadResult'>
  <ul>

  </ul>
</div>
<div class='bigPictureWrapper'>
  <div class='bigPicture'>

  </div>
</div>

<button id="uploadBtn">Upload</button>

<%-- jQuery를 이용하는 경우, 파일 업로드는 FormData 객체를 이용하여 처리한다. --%>
<%-- FormData : 가상의 <form> 태그와 같으며, Ajax를 이용하는 파일 업로드는 FormData를 이용하여 필요한 파라미터를 담아 전송하는 방식이다. --%>

<%-- 첨부파일 데이터는 formData에 추가한 뒤에 Ajax를 통해서 formData 자체를 전송한다. --%>
<%-- processData와 contentType은 반드시 'false'로 지정해야 전송된다. --%>
<script>
  $(document).ready(function (){
    // 업로드 가능 파일(확장자) 제한
    let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
    // 파일 최대 용량 제한 (5MB)
    let maxSize = 5242880;

    function checkExtension(fileName, fileSize) {

      if (fileSize >= maxSize) {
        alert("파일 사이즈 초과");
        return false;
      }

      if (regex.test(fileName)) {
        alert("해당 종류의 파일은 업로드할 수 없습니다.");
        return false;
      }
      return true;
    }

    // 브라우저에서의 섬네일 처리
    // <input type='file'>은 다른 DOM 요소들과 달리 readonly이므로, 안쪽의 내용을 수정할 수 없다.
    // 그러므로 별도의 방법으로 초기화하여 또 다른 첨부파일을 추가할 수 있도록 만들어야 한다.

    // 첨부파일 업로드 전, 아무 내용이 없는 <input type='file'> 객체가 포함된 <div>를 복사(clone)한다.
    var cloneObj  = $(".uploadDiv").clone();

    $("#uploadBtn").on("click", function (e){
      let formDate = new FormData();

      let inputFile = $("input[name='uploadFile']");

      let files = inputFile[0].files;

      console.log(files);

      /* add filedate to formaata */
      for(let i = 0; i< files.length; i++){
        // 파일 업로드 관련 유효성 검사 진행 : 파일 사이즈 및 업로드 가능 확장자를 판단한다.
        if(!checkExtension(files[i].name, files[i].sign)){
          return false;
        }

        formDate.append("uploadFile", files[i]);
      }

      $.ajax({
        // 업로드된 파일에 대한 결과 데이터를 JavaScript를 이용하여 처리하도록 한다.
        url: '/uploadAjaxAction',
        processData: false,
        contentType: false,
        data: formDate,
        type: 'POST',
        dataType: 'json',
        success: function (result){
          // alert("Uploaded");
          console.log(result);

          showUploadedFile(result);

          // 첨부파일 업로드 후, 복사된 객체를 <div> 내에 다시 추가하여 첨부파일 부분을 초기화시킨다.
          $(".uploadDiv").html(cloneObj.html());
        }
      }); //$.ajax

    });

    let uploadResult = $(".uploadResult ul");

    // showUploadedFile() : JSON 데이터를 받아 해당 파일의 이름을 추가한다.
    function showUploadedFile(uploadResultArr){
      var str = "";

      $(uploadResultArr).each(function(i, obj){
        // 업로드 된 파일 이름을 한 줄씩 출력한다.
        str += "<li>" + obj.fileName + "</li>";

        // if(!obj.image){
        //   let fileCallPath  = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
        //   //str += "<li><img src='/resources/img/attach.png'>"+obj.fileName+"</li>";
        //   str += "<li><a href='/download?fileName="+fileCallPath+"'>"+"<img src='/resources/img/attach.png'>"+obj.fileName+"</a></li>"
        // }else{
        //
        //   let fileCallPath =  encodeURIComponent( obj.uploadPath+ "/s_"+obj.uuid+"_"+obj.fileName);
        //   str += "<li><img src='/display?fileName="+fileCallPath+"'><li>";
        // }
      });
      uploadResult.append(str);
    }
  });
</script>


</body>
</html>