<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="com.kos.testlegacy.os.lecture.vo.OsLectureVO" %> 
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %>   
<% request.setCharacterEncoding("UTF-8");%> 
<%   
   Logger logger = LogManager.getLogger(this.getClass());
   logger.info("kosBoardSelectAll.jsp 페이지 >>> : ");
   
   //페이징 변수 세팅
      int pageSize = 0;
      int groupSize = 0;
      int curPage = 0;
      int totalCount = 0;
      String url = "";
      
   Object objPaging = request.getAttribute("pagingKBVO");
   OsLectureVO pagingKBVO = (OsLectureVO)objPaging;
   
   Object obj = request.getAttribute("listAll");
   List<OsLectureVO> list = (List<OsLectureVO>)obj;
   
   int nCnt = list.size();
   
   if(list.size() > 0){
   String nCntS = ":::: 전체 조회 건수  " + nCnt + " 건";
   String snb = "강의상세보기";
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
  table {
  position: absolute;
  top:10%;
  left:20%;
      border-collapse: collapse;
   
  }
   
  tr:last-child {
    border-bottom: 1px solid black; /* 원하는 선의 스타일과 색상을 지정하세요 */
  }
  td, th {
    padding: 20px; /* 모든 셀에 적용되는 내용과 셀 경계 사이의 간격 */
  }
  
  h1{
  top:3%;
  	position: absolute;
  	left: 46%;
  }
</style>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">

   $(document).ready(function(){
      
      $(document).on('click', '.lnum', function(){
         alert("lnum >>> : ");
         let lnum = $(this).val();
         alert("lnum >>> : " + lnum);
         
         location.href="kosmoCartDelete.h?lnum="+lnum;         
      });   
      
      //메인화면
      $(document).on('click','#homeButton',function(){
         location.href="mainlink.h";
      });
      
   });   
</script>
</head>
<body>
<h1><%= request.getAttribute("lname") %>페이지</h1>

<form name="lectureselectall" id="lectureselectall">


<table align="center" style="width: 60%; cellpadding: 20px;">
<thead>
<tr>   
   <th></th>
   <th>   </th>
   <!-- 
   <th>강의이름</th>
   <th>업로드날짜</th>
   <th>조회수</th>  -->
</tr>
</thead>
<%
for(int i=0; i<nCnt; i++){      
   OsLectureVO _ovo = list.get(i);   
   
   // 페이징 세팅
   pageSize = Integer.parseInt(pagingKBVO.getPageSize());
   groupSize = Integer.parseInt(pagingKBVO.getGroupSize());
   curPage = Integer.parseInt(pagingKBVO.getCurPage());
   totalCount = Integer.parseInt(_ovo.getTotalCount());
%>
<tbody>
<tr>      
	<td style="width: 200px;"><img src="<%= _ovo.getLfile() %>" alt="이미지" style="max-width: 100%; height: auto;"></td>

   <td colspan='10' style="width: 100px;"><span style="font-size: 20px;">
   <a href="osLectureSelectOne.h?lnum=<%= _ovo.getLnum() %>" style="text-decoration: none; color: black;">강의번호: <%= _ovo.getLnum() %><br><br>
   강의이름: <%= _ovo.getLname() %><br><br>
   강의내용: <%= _ovo.getLcur() %><br><br>
    가격:  <%= _ovo.getLprice() %>원<br><br>
    조회수:  <%= _ovo.getLhit() %></td>
         
</tr>
   
<%
   url = _ovo.getLname();
}



if(url.equals("국어")){
   url = "osLectureSelectK.h";
} else if(url.equals("수학")){
   url = "osLectureSelectM.h";
} else {url = "osLectureSelectE.h"; }
%>
<tr>
   <td colspan="7">
      <jsp:include page="lecturePaging.jsp" flush="true">
         <jsp:param name="url" value="<%= url %>"/>
         <jsp:param name="str" value=""/>
         <jsp:param name="pageSize" value="<%=pageSize%>"/>
         <jsp:param name="groupSize" value="<%=groupSize%>"/>
         <jsp:param name="curPage" value="<%=curPage%>"/>
         <jsp:param name="totalCount" value="<%=totalCount%>"/>
      </jsp:include>
   </td>
</tr>
<% } %>
</tbody>
<tfoot>
    <tr>
      <td colspan="10" align='right'>
        
        <input type="button" name="homeButton" id="homeButton" value="메인페이지" style="width: 100px; height: 40px;"> 
      </td>
    </tr>
  </tfoot>
</table>
</form>   
</body>
</html> 