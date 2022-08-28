<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    @import url("css/headerfooter.css");
</style>
<style>
  		h1{
			text-align:center;		
		}
       table{
            width:300px;
            height: 250px;
            border: 1px solid black;
            margin: auto;
            margin-bottom:20px;
            
        }
        td{
            border:1px solid black;
        }
        td:nth-child(1){
            text-align: center;
        }
        input{
            margin-left: 25px;
        }
        #login_button{
            width :180px;
            height: 30px;
            
            border:1px solid black;
        }
        
</style>

<%String id = (String)session.getAttribute("id");
	if(id != null){
		out.println("<script>");
		out.println("location.href = 'userinfo.jsp'");
		out.println("</script>");
	}
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
                <button><img src="/p5/imgStorage/signin.png" alt="sign in" onclick="location.href='Signup.html'"><br>회원가입</button>
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








<H1> 로그인</H1>
    <form method="post" action="login_ck.jsp" name="loginfrm">
       <table> 
           <tr>
           <td> 아이디</td>
           <td><input type="text" name="userid" placeholder="아이디"></td>
           </tr>
            <tr>
            <td>비밀번호 </td>
            <td><input type="password" name="userpw" placeholder="비밀번호"></td>
            </tr>
            <tr>
            <td colspan="2"><button id="login_button">로그인</button></td>
            </tr>
         </table>
        </form>   
        
        
        
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