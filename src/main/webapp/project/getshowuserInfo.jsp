<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" 
language="java" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%
	request.setCharacterEncoding("UTF-8");
	// 정보수정 화면으로 가기전에
	// 아이디 기준으로 회원정보를 조회해서 다음 화면으로 전달
	String id = (String) session.getAttribute("id");
	
    	//DB연결에 필요한 변수 선언
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";

	
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	
	try{
		// 드라이버 호출
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// con 생성
		con = DriverManager.getConnection(url, user, password);
		
		// sql 작성
		String sql = "select * from customer where id = ?";
		
		// pst 생성
		pst = con.prepareStatement(sql);
		pst.setString(1, id);
		
		// sql실행
		rs = pst.executeQuery();
		
		if(rs.next()){
			id = rs.getString(1);
			String name = rs.getString(2);
			String pw = rs.getString(3);
			String phone = rs.getString(4);
			String birth = rs.getString(5);
			String email = rs.getString(6);
			String gender = rs.getString(7);
			String point = rs.getString(8);
			
			// 포워드로 전달하기 위해
		
			request.setAttribute("userid", id);
			request.setAttribute("name", name);
			request.setAttribute("userpw", pw);
			request.setAttribute("phone", phone);
			request.setAttribute("birth", birth);
			request.setAttribute("email", email);
			request.setAttribute("gender", gender);
			request.setAttribute("point", point);
			
			// 포워드 이동
			request.getRequestDispatcher("showuserinfo.jsp").forward(request, response);
			
		} else{ // 세션이 만료된 경우
			response.sendRedirect("login2.jsp");
		}
	} catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("login2.jsp");
	} finally{
		try{
			if(con != null) con.close();
			if(pst != null) pst.close();
			if(rs != null) rs.close();
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