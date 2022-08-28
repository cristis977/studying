<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
    <%@page import="java.sql.DriverManager" %>
    <%@page import="java.sql.PreparedStatement" %>
    <%@page import="java.sql.ResultSet" %>
    <%@page import="java.sql.Statement" %>
    <%@page import="java.sql.SQLException" %>
    <%@page import="java.sql.Connection" %>
    
<%
	/*
	1. 폼에서 넘어온 데이터를 각각 처리합니다.
	2. SQL문을 이용해서 DB에 업데이트 작업.
	3. executeUpdate() 성공시 1을 반환, 실패시 0을 반환
	4. 업데이트가 성공하면 세션에 저장된 이름을 변경한 후에
		update_success.jsp로 리다이렉트
		
	      업데이트에 실패하면, update_fail.jsp로 리다이렉트
	*/
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("userid");
	String name = request.getParameter("name");
	String pw = request.getParameter("userpw");
	String phone = request.getParameter("phone");
	String birth = request.getParameter("birth");
	String email = request.getParameter("email");
	String point = request.getParameter("point");
	String gender = request.getParameter("gender");
	
	System.out.println(id);
	System.out.println(name);
	System.out.println(pw);
	System.out.println(phone);
	System.out.println(birth);
	System.out.println(email);
	System.out.println(point);
	System.out.println(gender);
	
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";
	
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try{
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		
		String sql = "update customer set name=?, password=?, phone=?, birthday=?, email=?,gender=?, point=? where id=?";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, name);
		pst.setString(2, pw);
		pst.setString(3, phone);
		pst.setString(4, birth);
		pst.setString(5, email);
		pst.setString(6, gender);
		pst.setString(7, point);
		pst.setString(8, id);
		
		int result = pst.executeUpdate();
		
		if(result == 1){
			session.setAttribute("id", id);
			
			response.sendRedirect("update_sc.jsp");
		} else{
			response.sendRedirect("update_fail.jsp");
		}
	} catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("update_fail.jsp");
	} finally{
		try{
			if(con != null) con.close();
			if(pst != null) pst.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>