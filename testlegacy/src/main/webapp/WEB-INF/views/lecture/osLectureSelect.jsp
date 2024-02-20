<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.kos.testlegacy.os.lecture.vo.OsLectureVO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제목 입력</title>
<style>
    div.img {
       
        left: 20%;
    }
 
    div.table {
        
        left: 30%;
        width: 1000px;
        heigt:3000px;
        
    }
    div.all{
    
    left: 33%;
    top: 15%;
    }
    table {
        
        border-spacing: 0 10px; /* 여백 조절 */
    }
    
</style>
</head>
<body>
    <h1 align='left'>강의상세페이지</h1>
    <hr>

    <% 
        Object obj = request.getAttribute("searchList");
        if (obj != null) {
            List<OsLectureVO> list = (List<OsLectureVO>) obj;
            for (OsLectureVO ovo : list) {
    %>
    
	    	
	            
	            
	            <div class="table" align='center'>
	                <table  align='center' style="width: 1500; height: 50%;">
	                    	<th rowspan='5'> 
	                    	<img src="<%= ovo.getLfile() %>" alt="이미지" width="200" height="200">
	                    	</th>
	                    	
	                      <tr>	
	                            <td style="text-align: left; width:500px">강의 번호</td>
	                            <td style="text-align: left; width:1000px"><%= ovo.getLnum() %></td><br>
	                      </tr>
	                      <tr>
	                            <td style="text-align: left; width:500px">강의 이름</td>
	                            <td style="text-align: left; width:1000px"><%= ovo.getLname() %></td><br>
	                    </tr>
	                            <td style="text-align: left; width:500px">강의 내용</td>
	                            <td style="text-align: left; width:1000px"><%= ovo.getLcur() %></td><br>
	                       <tr>
	                            <td style="text-align: left; width:500px">가격</td>
	                            <td style="text-align: left; width:1000px"><%= ovo.getLprice() %>원</td>
	                        </tr>
	                    
	                </table>
	                <hr>
	            </div>
	            
	            
	            </div>
    <% 
            }
        }
    %>
</body>

</html>
