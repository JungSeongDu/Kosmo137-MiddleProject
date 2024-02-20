<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.kos.testlegacy.os.kart.vo.OsBuyVO" %>
<%

	String mid ="";
	Cookie ck[] = request.getCookies();
	if(ck !=null && ck.length > 0){
		
		for(int i=0; i < ck.length; i++){
			
			if (ck[i].getName().equals("ID")){
				mid = ck[i].getValue();
			}
		}
	}
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/osProject/include/css/main.css">

<script type="text/javascript">
$(document).ready(function(){
    $("#submit").click(function(){
        $('#mainform').attr({
            "action": "osLectureSelectMain.h",
            "method": "GET"
        });
        form.submit();
    });
    
    $("#myPagebtn").click(function(){
    	 $('#mainform').attr({
             "action": "osMypage.h",
             "method": "GET"
         });
         form.submit();
    });
    
    $("#reviewbtn").click(function(){
    	 $('#mainform').attr({
             "action": "osRboardForm.h",
             "method": "GET"
         });
         form.submit();
    });
});

</script>

<style>
div.imgtable{
 poosition:relative;
 
}
div.table{
 poosition:relative;
 width:200px;
 left:60%;
 top:10%;
}
</style>

</head>
<body onload="counter_init()">
<form name="mainform" id="mainform">
<div class="topmiddle">
<div class="top">
	<div class="sitename">
	<h1>너 재수없다</h1>
	</div>
	<form id="selectMain">
    <div class="searchbar">
        <div class="searchbar1">
            <input type="text" id="search" name='searchValue'>
        </div>
        <div class="searchbar2">
            <button type="submit" id="submit"><img class="logoutbtn" src="/osProject/include/img/search.jpg" style="width: 65px; height: 60px;"></button>
        </div>  
    </div>


		
	<div class="login">
		<div class="login1">			
			<h3 align="left"><%= mid %>님 환영합니다</h3>
			 </div>	
			<a href="logout.h" class="loginbtn">로그아웃</a>
		 
	</div>
</div>


<div class="middle">
	<div class="menu" style="text-align:center">
		<div class="dropdown" >
		  <button onclick="myFunction()" class="dropbtn">모든강좌</button>
		  <div id="myDropdown" class="dropdown-content">
		    <a href="osLectureSelectK.h">국어</a>
		    <a href="osLectureSelectM.h">수학</a>
		    <a href="osLectureSelectE.h">영어</a>
		  </div>
		</div>

		<div class="dropdown">
		  <button id="myPagebtn" class="dropbtn">마이페이지</button>
		</div>
		<div class="dropdown">
		  <button  class="dropbtn" id='reviewbtn'>후기게시판</button>
		</div>

	</div>
</div>
</div>
<div class="all">
<div class="bottom">
      <div class="textbox">
         <p>수강중인 강의</p>
         </div>
      </div>

<%
List<OsBuyVO> list = (List<OsBuyVO>) request.getAttribute("listBuy");

if (list != null && !list.isEmpty()) {
    int nCnt = list.size();

    for (int i = 0; i < nCnt; i++) {
        OsBuyVO _obo = list.get(i);
%>

<!-- 수강중인 강의 -->
<div class="bottom1">
    <div class="infobox">
        <div class="imgtable">
            <div class="img">
                <img src="<%= _obo.getLfile() %>" alt="이미지" width="200" height="200">
            </div>
            <div class="table">
                <table align='center' style="width:400px;">
                    <tbody>
                      
                        <tr>
                            <th style="text-align: left; ">강의 이름</th>
                            <td><%= _obo.getLname() %></td>
                            <td style="text-align: left;"></td>
                        </tr>
                         <tr>
                            <th style="text-align: left;">강의 내용</th>
                            <td><%= _obo.getLcur() %></td>
                            <td style="text-align: left;"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<% 

}
        }
%>
<div class="textbox1">
         <p1>인기 교재</p>
         </div>
<div class="bottom2">
   <div class="infobox1">
       <div class="image-row">
    <div class="image-item">
      <img src="/osProject/include/img/kor1.jpg" alt="국어문학">
    </div>
    <div class="image-item">
      <img src="/osProject/include/img/kor2.jpg" alt="국어언매">
    </div>
    <div class="image-item">
      <img src="/osProject/include/img/math1.jpg" alt="수1">
    </div>
    <div class="image-item">
      <img src="/osProject/include/img/math2.jpg" alt="수2">
    </div>
    <div class="image-item">
      <img src="/osProject/include/img/eng1.jpg" alt="영어">
    </div>
    <div class="image-item">
      <img src="/osProject/include/img/eng2.jpg" alt="영어듣기">
    </div>
</div>
</div>
</div>


<div class="footer"></div>
</div>
</form>
</body>
</html>