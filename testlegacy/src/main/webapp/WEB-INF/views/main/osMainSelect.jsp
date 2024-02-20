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
        position: absolute;
        left: 20%;
    }
 
    div.table {
        position: absolute;
        left: 19%;
        width: 1000px;
        heigt:3000px;
        
    }
    div.all{
    position: absolute;
    left: 33%;
    top: 15%;
    }
    table {
        
        border-spacing: 0 10px; /* 여백 조절 */
    }
    
</style>
</head>
<body>
    <h1 align='center'>강의상세페이지</h1>
    <hr>

    <% 
        Object _obj = request.getAttribute("searchList");
        if (_obj != null) {
            List<OsLectureVO> list = (List<OsLectureVO>) _obj;
            for (OsLectureVO ovo : list) {
    %>
    	<div class="all">
            <div class="img">
                <img src="<%= ovo.getLfile() %>" alt="이미지" width="200" height="200">
            </div>
            <div class="table">
               
                <table align='center' style="width: 50%; height: 50%;">
                
                    <tbody>
                        <tr>
                            <th style="text-align: left; width:30%;">강의 번호</th>
                            <td style="text-align: left;"><%= ovo.getLnum() %></td>
                        </tr>
                        <tr>
                            <th style="text-align: left; width:30%;">강의 이름</th>
                            <td style="text-align: left;"><%= ovo.getLname() %></td>
                        </tr>
                        <tr>
                            <th style="text-align: left; width:30%;">강의 내용</th>
                            <td style="text-align: left;"><%= ovo.getLcur() %></td>
                        </tr>
                        <tr>
                            <th style="text-align: left; width:30%;">가격</th>
                            <td style="text-align: left;"><%= ovo.getLprice() %>원</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            </div>
    <% 
            }
        }
    %>
</body>

</html>
