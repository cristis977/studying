package ActionClass;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBclass.*;

@WebServlet("/MovieInfo")
public class MovieInfo extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String moviecode = request.getParameter("moviecode");
		String id = request.getParameter("Id");
		DBConnector dbc = new DBConnector();
		Movie m = dbc.catchmovie(moviecode);

		request.setAttribute("Id", id);
		request.setAttribute("Movie", m);
		request.getRequestDispatcher("/jsp/movieinfo.jsp").forward(request, response);
	}
}
