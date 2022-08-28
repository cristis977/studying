<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DBclass.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<% String id = (String)request.getAttribute("Id"); %>
<% Movie m = (Movie)request.getAttribute("Movie"); %>
<title>Movie Explain : <%=m.getTitle()%></title>
<style>
        table{
            border:1px solid black;
        }
        td{
            border:1px solid red;
            text-align: center;
        }
        .ts{
            border-color:green;
        }
        input{
        	border: none;
            width:300px;
            text-align: center;
        }
        button{
            width:400px;
            height:50px;
            font-size:30px;
            font-weight:bold;
            background-color:red;
            color:white;
        }
        .none{
            width:0px;
            height:0px;
            font-size:0px;
            display: none;
        }
</style>
</head>
<body>
<form name="frm" method="post" action="/pe/OpenPlaylist">
<input class="none" type="text" name="Id" value="<%=id%>" readonly>
<input class="none" type="text" name="moviecode" value="<%=m.getMoviecode()%>" readonly>
<center>
        <table>
        	<tr>
        	<td colspan="2">
        	<img src="images/<%=m.getMoviecode()%>.png" width="400px" height="605px">
        	</td>
        	</tr>
            <tr>
                <td>제목</td>
                <td>
                <input type="text" name="title" value="<%=m.getTitle()%>" readonly>
                </td>
            </tr>
            <tr>
                <td>개봉일</td>
                <td>
                <input type="text" name="release" 
                value="<%=m.getYear()%>년 <%=m.getMonth()%>월 <%=m.getDate()%>일" readonly>
                </td>
            </tr>
            <tr>
                <td>제작사</td>
                <td>
                <input type="text" name="production" value="<%=m.getProduction()%>" readonly>
                </td>
            </tr>
            <tr>
                <td>상영 등급</td>
                <td>
                <input type="text" name="film_rating" value="<%=m.getFilm_rating()%>" readonly>
                </td>
            </tr>
            <tr>
                <td>상영 시간(분)</td>
                <td>
                <input type="text" name="runningtime" value="<%=m.getRunningtime()%>" readonly>
                </td>
            </tr>
            <tr>
                <td>감독</td>
                <td>
                <input type="text" name="director" value="<%=m.getDirector()%>" readonly>
                </td>
            </tr>
            <tr>
                <td>장르</td>
                <td>
                <input type="text" name="genre" value="<%=m.getGenre()%>" readonly>
                </td>
            </tr>
            <tr>
                <td>주연 성우</td>
                <td>
                <input type="text" name="leading_role" value="<%=m.getLeading_role()%>" readonly>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="ts"><button>예매하기</button></td>
            </tr>
        </table>
</center>
</form>
</body>
</html>