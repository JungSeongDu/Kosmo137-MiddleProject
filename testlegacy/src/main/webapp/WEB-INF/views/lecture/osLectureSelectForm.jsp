<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
 -->
<link rel="stylesheet" href="/empSpring/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="/empSpring/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
    $("#search_btn").click(function(){
        // 이미지 URL 설정
      
        // 이미지 URL을 form으로 전송
        var form = $("#lectureSearchForm");
        form.attr({
            "action": "osLectureSelect.h",
            "method": "GET"
        });

     
        form.submit();
    });
});

</script>

</head>
<body>
<h3>springEmpSelectForm.jsp</h3>
<hr>
<form name="lectureSearchForm" id="lectureSearchForm">
   <select id="searchFilter" name="searchFilter">
      <option value="key_00">전체-----------</option>
      <option value="key_01">강의번호</option>
      <option value="key_02">강의이름</option>
   </select>
   <input type="text" id="keyword" name="keyword" placeholder="검색어 입력"><br>   
   <!--
   <input type="text" id="startDate" name="startDate" style="text-align:left; width:100px; height:13px;" placeholder="시작일 "> 
    -->      
      
   <input type="button" id="search_btn" name="search_btn" value="검색">
   <input type="reset" id="reset_btn" name="reset_btn" value="리셋"><br>
</form>
</body>
</html>
