package ActionClass;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBclass.*;

@WebServlet("/choiceseat")
public class ChoiceSeat extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("Id");
		String listcode = request.getParameter("listcode");
		DBConnector dbc = new DBConnector();
		Movie m = dbc.catchmovie(listcode.substring(0, 12));
		Theater t = dbc.catchtheater(listcode.substring(12, 18));
		Cinema c = dbc.catchcinema(listcode.substring(12, 20));
		Playlist p = dbc.catchplaylist(listcode);
		ArrayList<Seat> seats = dbc.catch_seatinfo(c.getCinemacode());
		
		

		request.setAttribute("Id", id);
		request.setAttribute("Movie", m);
		request.setAttribute("Theater", t);
		request.setAttribute("Cinema", c);
		request.setAttribute("Playlist", p);
		request.setAttribute("Seats", seats);
		request.getRequestDispatcher("jsp/choiceseat.jsp").forward(request, response);
		
	}

}
