<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>logout</title>
<%
	session.invalidate();
%>
<script>
	alert("로그아웃 되었습니다.");
	location.href="main.html";
</script>
</head>
<body>


</body>
</html>