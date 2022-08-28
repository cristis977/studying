package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerBean;
import customer.CustomerDAO;

@WebServlet("/SignUP")
public class SignUp extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doReq(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doReq(request, response);
	}	
	protected void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); 
		CustomerBean bean = new CustomerBean();
		CustomerDAO cdao = new CustomerDAO();
		//�뤌�뿉 �엯�젰�븳 �젙蹂대�� 媛뽮퀬�샂.

		bean.setId(request.getParameter("id"));
  		//�뙣�뒪�썙�뱶, �뙣�뒪�썙�뱶�솗�씤�쓣 鍮꾧탳�븯湲� �쐞�빐 蹂��닔�뿉 ���옣.
		String pass1 = request.getParameter("password");
		String pass2 = request.getParameter("password2");
		bean.setPass1(pass1);
		bean.setEmail(request.getParameter("email"));
		bean.setName(request.getParameter("name"));
		bean.setPhone(request.getParameter("phone"));
		bean.setGender(request.getParameter("gender"));
		bean.setBirthday(request.getParameter("birthday"));
		bean.setPoint(0);

		
		if(pass1.equals(pass2)) { 
			cdao.MemberInsert(bean);
			response.sendRedirect("Signup2.jsp");
		}else {
			RequestDispatcher rdis = request.getRequestDispatcher("LoginError.jsp");
			rdis.forward(request, response);
		}
		
		
		
		
	}
}