<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" type="text/css" href="/osProject/include/css/mypage.css">
<script type="text/javascript">
  alert("자바스크립트 진입 >>> : ");

  $(document).ready(function(){
    alert("jQuery ready() 함수 블럭 진입 >>> : ");
    
    // 수정하기 버튼
    $(document).on("click", "#btn", function(){ 
      alert("upBtn 버튼 블럭 진입 >>> :");
      console.log("upBtn 버튼 블럭 진입 >>> :");
      
      $('#osloginForm').attr({
        'action':'osMypageForm.h',
        'method':'GET',
        'enctype':'multipart/form-data'
      }).submit(); 
    });
  });
</script>
</head>
<body>
  <div class="MPlogin">
    <h2>마이 페이지 수정</h2>
    <form name="osloginForm" id="osloginForm">
      <div class="id">
        <label for="mid">아이디</label>
        <input type="text" name="mid" id="mid" style="width:150px;">
      </div>
      <div class="pw">
        <label for="mpw">비밀번호</label>
        <input type="text" name="mpw" id="mpw" style="width:150px;">
      </div>
      <div class="loginbtn">
        <button type="button" name="btn" id="btn" style="width:246px; height:35px;">로그인</button>
      </div>
    </form>
  </div>
</body>
</html>