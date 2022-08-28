package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;

@WebServlet("/duplicated")
public class DuplicatedServlet  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		 
		System.out.println("duplicated");
		String id  =req.getParameter("id");
		CustomerDAO  dao = new CustomerDAO();
		int result  =dao.duplicatedID(id);
		
		 PrintWriter out  =resp.getWriter();
		 out.print( result);
	}
 
}
