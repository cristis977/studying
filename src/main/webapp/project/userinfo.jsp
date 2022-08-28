<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
    <%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
    @import url("css/headerfooter.css");
</style>
</head>

<style>
	   
	    
	    #edge{
	        width: 380px;
	        border: 1px solid black;
	        position:relaitvie;
	        margin:center;
	        text-align:center;
	        margin-top : 20px;
	        margin-bottom : 20px;
	    }
	    p{
	        text-align: center;
	    }
	    
	    #list{
	        text-align: center;
	  		list-style:none;
	  		margin-right:20px;
	    }
		
	    </style>
<% 
	String id = (String)session.getAttribute("id");
	if(id != null){
%>
	
	</head>
	<body>
	<a id="up" href="#headerTopContainer"><img src="/p5/imgStorage/uptotop.png"></a>

    <header>
        <div id="headerTopContainer">
            <img src="/p5/imgStorage/movieBarImg.png" alt="TopMovieAd">
        </div>
        <div id="headerLogoAndButtonContainer">
            <div id="logoContainer">
                <img src="/p5/imgStorage/logo1.jpeg" alt="Logo">
            </div>
            <div id="buttonContainer">
                <button><img src="/p5/imgStorage/signin.png" alt="sign in"><br>회원가입</button>
                <button><img src="/p5/imgStorage/signup.png" alt="sign in" onclick="location.href='login2.jsp'"/><br>로그인</button>
                <button><img src="/p5/imgStorage/info.png" alt="info" onclick="location.href='userinfo.jsp'"/><br>회원정보</button>
                <button><img src="/p5/imgStorage/cs.png" alt="cs"><br>고객센터</button>
            </div>
        </div>
        
        <div id="headerbottomContainer">
            <div id="headerbottomButtonContainer">
                <button>영화</button>
                <button>극장</button>
                <button>예매</button>
                <button>스토어</button>
                <button>이벤트</button>
                <button>혜택</button>
            </div>
            <div id="headerbottomSearchContainer">
                <input type="text" placeholder="영화를 검색해보세요"><button>Search</button>
            </div>
        </div>
    </header>
	
	
	
	
	<div style="margin:auto;text-align:center;">
	   <form style="display:inline-block;" id="edge">
	    <p>제한된 기능을 이용할 수 있습니다.</p>
	    <ul id="list">
		    <li><a href="getshowuserInfo.jsp">회원정보확인</a> </li>
		    <li><a href="">나의 예매 현황</a> </li>
		    <li><a href="getuserInfo.jsp">회원 정보 수정</a></li>
		    <li><a href="logout.jsp">로그아웃</a></li>
	    </ul>   
	</div>
	</form>
	<% } else{
		out.println("<script>");
		out.println("alert('로그인이 필요합니다.')");	
		out.println("location.href = 'login2.jsp'");
		out.println("</script>");
	}
	%>
	
	 <footer>
        <div class="footerMenu">
            <ul>
                <li>회사소개</li>
                <li>Investor Relations</li>
                <li>인재채용</li>
                <li>공지사항</li>
                <li>고객의 소리</li>
                <li>이용약관</li>
                <li>개인정보처리방침</li>
                <li>제휴마케팅</li>
                <li>광고안내</li>
            </ul>
        </div>
        <div class="footerSection1">
            <div><img src="/p5/imgStorage/logo1.jpeg"></div>
        </div>
        <div class="footerSection2">
            <p>상호명 및 호스팅 서비스 제공: Acorn Inc.</p>
            <p>대표이사 : 오준혁</p>
            <p>사장 : 정해윤</p>
            <p>이사장 : 우지윤</p>
            <p>The largest shareholder : 주샛별</p>
            <p>서울시 마포구 양화로 122</p>
            <p>사업자 등록번호 : 101-86-89995</p>
            <p>통신판매업신고 : 제2014-서울종로-0532호</p>
        </div>
        <div class="footerSection3">
            <b>365고객센터 | 전자금융거래분쟁처리담당</b>
            <h1>02-2231-6412</h1>
            <p>서울시 마포구 양화로 122 LAB빌딩 3층, 4층</p>
        </div>
        <div class="footerSection4">
            <b>우리은행 채무지급보증 안내</b>
            <p>당사는 고객님이 현금 결제한 금액에 대해
            우리은행과 채무지급보증 계약을 체결하여
            안전거래를 보장하고 있습니다</p>
        </div>

    </footer>
	
	
	
</body>
</html>