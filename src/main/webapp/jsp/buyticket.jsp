<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DBclass.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy ticket this is</title>
<% String name = (String)request.getAttribute("Name"); %>
<% Movie m = (Movie)request.getAttribute("Movie"); %>
<% Theater t = (Theater)request.getAttribute("Theater"); %>
<% Cinema c = (Cinema)request.getAttribute("Cinema"); %>
<% Playlist p = (Playlist)request.getAttribute("Playlist"); %>
<% Seat s = (Seat)request.getAttribute("Seat"); %>
<% Ticket i = (Ticket)request.getAttribute("Ticket"); %>
<style>
    table{
        border:1px solid red;
    }
    td{
        border:1px solid red;
        text-align:center;
    }
</style>
</head>
<body>
<center>
    <table>
        
        <tr>
            <td>영화관</td>
            <td><%=t.getBrunch_name()%></td>
        </tr>
        
        <tr>
            <td>상영관/좌석</td>
            <td><%=c.getName()%>/<%=s.getPlace()%></td>
        </tr>
        <tr>
            <td>주문번호</td>
            <td><%=i.getTicketcode()%></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><%=name%></td>
        </tr>
        <tr>
            <td>영화</td>
            <td><%=m.getTitle()%></td>
        </tr>
        <tr>
            <td>상영 시간</td>
            <td><%=p.getStart_time()%> ~ <%=p.getEnd_time()%></td>
        </tr>

        <tr>
            <td>가격</td>
            <td><%=p.getPrice()%> 원</td>
        </tr>
    </table>
</center>
</body>
</html>