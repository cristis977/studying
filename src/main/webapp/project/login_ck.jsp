<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
    <%@ page import="java.io.PrintWriter" %>
    <%@ page import="project.UserDao" %>
    <%@ page import="project.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head> 
<body>
<% 	String id = (String) request.getParameter("userid");
	String pw = (String) request.getParameter("userpw");
	UserDao userDao = new UserDao();
	int result = userDao.User_login(id, pw);
	
	
	if (result == 1){ // 로그인 정보가 맞으면 자바스크립트를 실행하여 페이지를 이동시킴
		PrintWriter script = response.getWriter();
		HttpSession sessionck = request.getSession();
		sessionck.setAttribute("id", id);
		script.println("<script>");
		script.println("location.href = 'main.html'"); // main 페이지로 사용자를 보냄 
		script.println("</script>");
		out.print(id);
		out.print(pw);
	}
	else if (result == 0){ 
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('비밀번호가 틀립니다.')");	
		script.println("history.back()"); // 이전 페이지로 사용자를 돌려 보냄.	
		script.println("foucs.userid()");
		script.println("</script>");
	}
	else if (result == -2){ 
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('존재하지 않는 아이디입니다.')");	
		script.println("history.back()");	
		script.println("</script>");
	}
	else if (result == -1){ 
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('아이디와 비밀번호를 확인해 주세요')");	
		script.println("history.back()");	
		script.println("</script>");
	}
%>


</body>
</html>