<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

   String mid ="";
   String mpw ="";
   Cookie ck[] = request.getCookies();
   if(ck !=null && ck.length > 0){
      
      for(int i=0; i < ck.length; i++){
         
         if (ck[i].getName().equals("ID")){
            mid = ck[i].getValue();
         } else if(ck[i].getName().equals("PW")){
            mpw = ck[i].getValue();
         }
      }
   }
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>osLoginForm</title>
<style type = "text/css">
body {
   background-color:#8c9696;
}
.div1{
   background : #D3C9B5;
   border : 1px;
   width : 350px;
   height : 280px;
   margin : 50px auto;
   padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); 
}


table{
   width: 100%;
    margin-top: 20px;
   
}

input[type="text"],
input[type="password"] {
       width: calc(100% - 12px); 
    padding: 8px;
    border-radius: 8px;
    border: 1px solid #ccc;
    margin-bottom: 10px;
    box-sizing: border-box;

}
#btn {
    width: 100%;
    height: 35px;
    border: none;
    background-color: #007bff;
    color: white;
    border-radius: 8px;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }

#btn:hover {
    background-color: #0056b3;
</style>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){

   $("#mid").attr('placeholder','아이디');
   $("#mpw").attr('placeholder','비밀번호');
   
   $("#btn").click(function(){
      console.log("btn >>> : ");
      auto_login();
      
      $('#osloginForm').attr({
         'action' : "login.h",
         'method' : 'POST',
         'enctype' : 'application/x-www-form-urlencoded'
      }).submit();

   });

   function auto_login(){
   if ($('.chek:checked').length == 1){
         alert("자동로그인 정보 입력완료");
      return;
   }}
});

</script>

</head>
<body>
<div class = "div1">
<hr>
<h1 align="center">OS로그인</h1>
<hr>
<form name = "osloginForm" id="osloginForm">
<table border="0" align="center">

<tr>
<th>ID</th>
<td><input type="text" name="mid" id="mid" style="width:150px;" value="<%= mid %>"></td>
</tr>

<tr>
<th>PASSWORD</th>
<td><input type="password" name="mpw" id="mpw" style="width:150px;" value="<%= mpw %>"></td>
</tr>

<tr>
<td><a href="osMemInsertForm.h" style="text-decoration: none; color: #11155e;"><span style="font-size: 12px; font-weight: bold;">회원가입</font></a><br>
<a href="idFindForm.h" style="text-decoration: none; color: #11155e;"><span style="font-size: 12px; font-weight: bold;">아이디/비밀번호 찾기</font></a>
<td align="right">
<input type="checkbox" name="chek" id="chek" class="chek">자동로그인
<button type="button" id="btn" style="width:70px; height:40px;">LOGIN</button>
</td>
</tr>
</body>
</html>