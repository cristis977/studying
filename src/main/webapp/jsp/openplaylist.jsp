<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DBclass.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Theater Selection</title>
<% String id = (String)request.getAttribute("Id"); %>
<% Movie m = (Movie)request.getAttribute("Movie"); %>
<% ArrayList<Theater> theaters = (ArrayList<Theater>)request.getAttribute("Theaters"); %>
<% ArrayList<Cinema> cinemas = (ArrayList<Cinema>)request.getAttribute("Cinemas"); %>
<% ArrayList<Playlist> playlists = (ArrayList<Playlist>)request.getAttribute("Playlists"); %>
<style>
    table{
        border:1px solid blue;
    }
    td{
        border:1px solid blueviolet;
        width:100px;
        text-align:center;
    }
    .t2{
        width:200px;
    }
    .t6{
        width:636px;
    }
    .br{
        border-color:red;
        margin-top:1px;
    }
    .bm{
        border-color:mediumspringgreen;
    }
    a{
        text-decoration: none;
    }
</style>
</head>
<body>
<center>
<table>
        <tr>
            <td class="t2">영화 제목</td>
            <td class="t6" colspan="2"><%=m.getTitle()%></td>
        </tr>
        <tr>
            <td>상영일</td>
            <td >2022년 08월 06일</td>
            <td >서울 동대문구/중랑구/성동구/광진구</td>
        </tr>
    </table>
    <% for(int th=0; th<theaters.size(); th++){ 
    		Theater t = theaters.get(th);%>
    <table class="br">
        <tr>
            <td colspan="8" class="bm"><%=t.getBrunch_name()%></td>
        </tr>
        <%	
        	ArrayList<Cinema> tsames = new ArrayList<>();
        	for(int ci=0; ci<cinemas.size(); ci++){
        		Cinema c = cinemas.get(ci);
        		if(t.getTheatercode().equals(c.getCinemacode().substring(0, 6))){
        			tsames.add(c);
        		}
        	}
        	for(int ci=0; ci<tsames.size(); ci++){
        		Cinema c = tsames.get(ci);
        		ArrayList<Playlist> csames = new ArrayList<>();
        		for(int li=0; li<playlists.size(); li++){
        			Playlist p = playlists.get(li);
        			if(c.getCinemacode().equals(p.getListcode().substring(12, 20))){
        				csames.add(p);
        			}
        		}
        		%>
        <tr>
        	<% for(int li=0; li<csames.size(); li++){ 
        		Playlist p = csames.get(li); %>
            	<td class="bm"><a href="/pe/choiceseat?listcode=<%=p.getListcode()%>&Id=<%=id%>">
           		<%=p.getStart_time()%> ~ <%=p.getEnd_time()%><br><%=c.getName()%></a></td>
            <% } %>
        </tr>
        <% } %>
    </table>
    <% } %>
</center>
</body>
</html>