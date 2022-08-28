package ActionClass;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBclass.*;

@WebServlet("/buyticket")
public class BuyTicket extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("Id");
		String listcode = request.getParameter("listcode");
		String place = request.getParameter("place");
		
		long time = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		SimpleDateFormat af = new SimpleDateFormat("a");
		String timer = sdf.format(time);
		String as = af.format(time);
		//System.out.println(timer);
		//System.out.println(as);
		if(as.equals("오후")) {
			char changer[] = new char[timer.length()];
			for(int c=0; c<timer.length(); c++) {
				changer[c] = timer.charAt(c);
			}
			int reverse = Integer.parseInt(timer.substring(8,10));
			reverse += 12;
			//System.out.println(reverse);
			changer[8] = (char)(48+(reverse/10));
			//System.out.println(changer[8]);
			changer[9] = (char)(48+(reverse%10));
			//System.out.println(changer[9]);
			String x = "";
			for(int c=0; c<changer.length; c++) {
				x += changer[c];
			}
			timer = x;
			System.out.println(x);
		}
		

		DBConnector dbc = new DBConnector();
		Playlist p = dbc.catchplaylist(listcode);
		Seat s = dbc.catchseat(place);
		Movie m = dbc.catchmovie(listcode.substring(0, 12));
		Theater t = dbc.catchtheater(listcode.substring(12, 18));
		Cinema c = dbc.catchcinema(listcode.substring(12, 20));
		
		dbc.maketicket(timer, id, p.getPrice(), listcode, s.getSeatcode());
		
		Ticket i = dbc.timecheck_ticket(timer);
		
		int changer = -1;
		try {
			changer = Integer.parseInt(id);
		}catch(NumberFormatException e) {
			changer = -1;
		}
		
		String name = null;
		if(changer==-1) {
			Customer co = dbc.check_id(id);
			name = co.getName();
		}else {
			Staff st = dbc.check_co(id);
			name = st.getName();
		}
		
		
		
		
		request.setAttribute("Name", name);
		request.setAttribute("Movie", m);
		request.setAttribute("Theater", t);
		request.setAttribute("Cinema", c);
		request.setAttribute("Playlist", p);
		request.setAttribute("Seat", s);
		request.setAttribute("Ticket", i);
		request.getRequestDispatcher("/jsp/buyticket.jsp").forward(request, response);
		
		
	}
}
