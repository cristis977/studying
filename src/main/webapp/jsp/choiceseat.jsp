<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DBclass.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<% String id = (String)request.getAttribute("Id"); %>
<% Movie m = (Movie)request.getAttribute("Movie"); %>
<% Theater t = (Theater)request.getAttribute("Theater"); %>
<% Cinema c = (Cinema)request.getAttribute("Cinema"); %>
<% Playlist p = (Playlist)request.getAttribute("Playlist"); %>
<% ArrayList<Seat> seats = (ArrayList<Seat>)request.getAttribute("Seats"); %>
<title>Choice to seat</title>
<style>
    table{
        border:1px solid red;
    }
    button{
        width:50px;
        height:50px;
        border:1px solid black;
        background-color: lightblue;
    }
    .long{
        width:535px;
        background-color: green;
    }
    td{
        text-align:center;
    }
    .r{
        border:1px solid red;
    }
    .no{
	   	border:none;
      	background:none;
    }
</style>
<script>
    let buy = 0;
    let c = "";
    function ck(obj){
        let o = obj;
        let b = document.getElementById("buys");
        if(c!=o.innerText){
            b.innerHTML = "<style> #"+o.innerText+"{ background-color:red; }</style>";
            c = o.innerText;
        }else{
            b.innerHTML = "";
            c = "";
        }
    }
    function goes(){
        if(c!=""){
        	let text = '/pe/buyticket?Id=<%=id%>&place='+c+'&listcode=<%=p.getListcode()%>';
        	location.href = text;
        }else{
            alert("구매할 좌석을 선택하세요.");
        }
    }
</script>
</head>
<body>
<center>
<div id="buys"></div>
    <table>
        <tr>
            <td colspan="6" class="r"><%=m.getTitle()%></td>
            <td colspan="2" class="r"><%=p.getStart_time()%></td>
            <td colspan="2" class="r"><%=p.getEnd_time()%></td>
        </tr>
        <tr>
            <td colspan="4" class="r"><%=t.getBrunch_name()%></td>
            <td colspan="2" class="r"><%=c.getName()%></td>
            <td colspan="4" class="r">20<%=p.getListcode().substring(20, 22)%>년 
            <%=p.getListcode().substring(22, 24)%>월 <%=p.getListcode().substring(24, 26)%>일</td>
        </tr>
        <%  int se_cnt = 0; 
        	if(seats.size()%10==0){
        		se_cnt = seats.size()/10;	
        	}else{
        		se_cnt = seats.size()/10 + 1;
        	}
        	
        	for(int sec=0; sec<se_cnt; sec++){	
        	 %>
        
        <tr>
        	
        	<% for(int sn=sec*10; sn<(sec+1)*10; sn++){
        		if(seats.size()>sn){
        			Seat sc = seats.get(sn); %>
            <td><button id="<%=sc.getPlace()%>" onclick="ck(this)"><%=sc.getPlace()%></button></td>
     
            	<% }else{ %>
            <td><button class="none"></button></td>
            	<% } %>
            <% }%>
        </tr>
        <% } %>
        <tr>
            <td colspan="10"><button class="long" onclick="goes()">구매</button></td>
        </tr>
    </table>
</center>
</body>
</html>