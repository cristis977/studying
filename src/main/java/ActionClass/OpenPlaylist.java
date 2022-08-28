package ActionClass;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBclass.*;


@WebServlet("/OpenPlaylist")
public class OpenPlaylist extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String moviecode = request.getParameter("moviecode");
		String Id = request.getParameter("Id");
		//System.out.println(moviecode);

		DBConnector dbc = new DBConnector();
		
		Movie m = dbc.catchmovie(moviecode);
		ArrayList<Theater> theaters = dbc.catch_theaterinfo(moviecode);
		ArrayList<Cinema> cinemas = dbc.catch_cinemainfo(moviecode);
		ArrayList<Playlist> playlists = dbc.catch_listinfo(moviecode);

		request.setAttribute("Id", Id);
		request.setAttribute("Movie", m);
		request.setAttribute("Theaters", theaters);
		request.setAttribute("Cinemas", cinemas);
		request.setAttribute("Playlists", playlists);
		request.getRequestDispatcher("/jsp/openplaylist.jsp").forward(request, response);
	}
}
