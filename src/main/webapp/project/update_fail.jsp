<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<%
out.println("<script>");
out.println("alert('잘못된 정보 입력입니다.')");	
out.println("history.back()");	
out.println("</script>");

%>

</head>
<body>

</body>
</html>