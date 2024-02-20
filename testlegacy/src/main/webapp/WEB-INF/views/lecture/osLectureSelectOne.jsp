<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="com.kos.testlegacy.os.lecture.vo.OsLectureVO" %> 
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<% request.setCharacterEncoding("UTF-8");%> 
<%	
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("kosBoardSelectAll.jsp 페이지 >>> : ");

	Object obj = request.getAttribute("listOne");
	List<OsLectureVO> list = (List<OsLectureVO>)obj;
	
	int nCnt = list.size();
	String nCntS = ":::: 전체 조회 건수  " + nCnt + " 건";
	String snb = "강의상세보기";
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/osProject/js/common.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$(document).on("click","#kart",function(){
		$('#osLectureForm').attr({
			'action' : "osKartInsert.h",
			'method' : 'POST',
			'enctype' : 'application/x-www-form-urlencoded'
		}).submit();
	});
});
</script>
<style>
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            position: absolute;
            top:15%;
            left:25%;
        }

        th, td {
            border: 1px solid #000;
            padding: 8px;
            text-align: left; /* 텍스트 왼쪽 정렬 */
        }

        img {
            width: 50px;
            height: 50px;
        }

       #kart {
            display: block;
            float: right; /* 버튼을 오른쪽에 위치시키기 위해 float 사용 */
            margin-top: 20px; /* 필요에 따라 상하 여백 조절 */
            font-size: 16px;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
           
        }
        .kart{
        	position:absolute;
        	left:69%;
        	top:51%;
        }
        h1{
  top:7%;
  	position: absolute;
  	left: 46%;
  }
    </style>
</head>
<body>
<form name="osLectureForm" id="osLectureForm">
<h1 align='center'>장바구니담기</h1>
<table style="width: 50%; cellpadding: 20px;">
<tr>
    <td style="width: 10%; text-align: left; border: none;"></td>
    <td style="width: 20%; text-align: left; border: none;"></td>
   
</tr>
<%
for(int i=0; i<nCnt; i++){     
    OsLectureVO _ovo = list.get(i);    
    
%>
<tr>
    <td>
        <!-- 이미지 출력 -->
        <img src="<%= _ovo.getLfile() %>" alt="이미지" style="max-width: 100%; height: auto; width: 250px;">
        <!-- 이미지 URL hidden input -->
        <input type="hidden" name="lfile" value="<%= _ovo.getLfile() %>">
    </td>
    
    
    <td class='tt' colspan='10' style="width: 70%;">
    <input type="hidden" name="lnum" id="lnum" value="<%= _ovo.getLnum() %>">
    강의번호: <%= _ovo.getLnum() %> <br><br>
    
    <input type="hidden" name="lname" id="lname" value="<%= _ovo.getLname() %>">
   강의이름: <%= _ovo.getLname() %><br><br>
   
   <input type="hidden" name="lcur" id="lcur" value="<%= _ovo.getLcur() %>">
   강의내용: <%= _ovo.getLcur() %><br><br>
    
    <input type="hidden" name="lprice" id="lprice" value="<%= _ovo.getLprice() %>" >
   가격: <%= _ovo.getLprice() %><br><br>
   
   <input type="hidden" name="lhit" id="lhit" value="<%= _ovo.getLhit() %>" >
   조회수: <%= _ovo.getLhit() %></td><br><br>
   
   
</tr>
<% } %>

</table>
<div class='cart'>
<input type="button" name="kart" class='kart' id="kart" value="장바구니"></div>
</form>
</body>
</html>