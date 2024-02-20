<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	alert("자바스크립트 진입 >>> : ");
	
	$(document).ready(function(){
		alert("jQuery ready() 함수 블럭 진입 >>> : ");

		$(document).on("click", "#idBtn", function(){ 
				alert("inBtn 버튼 블럭 진입 >>> :");
				console.log("inBtn 버튼 블럭 진입 >>> :");
				
			$('#emailfrom').attr({
				'action':'idFindSelect.h',
				'method':'GET',
				'enctype':'multipart/form-data'
			}).submit(); 
		});
	});
</script>
</head>
<body>
<form name="emailfrom" id="emailfrom">
	<table border="1">
			<tr>
				<td colspan="2" > 비밀번호 찾기</td>
			</tr>
			<tr>
				<td><input type="text" name="mid" id="mid"> 아이디를 입력하세요</td>
				<td><input type="text" name="memail" id="memail"> 이메일을 입력하세요</td>
				<td><button type="button" id="idBtn"> 찾기 </button></td>
			</tr>
	</table>
</form>
</body>
</html>