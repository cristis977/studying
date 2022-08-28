package ActionClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBclass.*;

public class DBConnector {
	
	private String driver = "oracle.jdbc.driver.OracleDriver" ;
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="scott";
	private String password="tiger";
	private Connection con = null;
	
	private void dbCon() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			/*
			if(con!=null) {
				System.out.println("Database Connection");
			}
			*/
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Movie catchmovie(String moviecode) {
		Movie m = null;
		
		try {
			dbCon();
			String sql = "select * from movie where moviecode='"+moviecode+"'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				m = new Movie(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),Integer.parseInt(rs.getString(6)),rs.getString(7),
						rs.getString(8),rs.getString(9));
				//System.out.println(m);
			}

			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	
	public ArrayList<Theater> catch_theaterinfo(String moviecode) {
		ArrayList<Theater> theater_list = new ArrayList<>();
		
		try {
			dbCon();
			String sql = "select t.theatercode , t.brunch_name, t.address from "
					+ "(select distinct substr(listcode,13,6) sub from playlist where "
					+ "substr(listcode,0,12)='"+moviecode+"' order by sub) "
							+ "join theater t on sub = t.theatercode";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Theater t = new Theater(rs.getString(1),rs.getString(2),rs.getString(3));
				theater_list.add(t);
				//System.out.println(t);
			}

			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theater_list;
	}
	
	public ArrayList<Cinema> catch_cinemainfo(String moviecode) {
		ArrayList<Cinema> cinema_list = new ArrayList<>();
		
		try {
			dbCon();
			String sql = "select c.cinemacode, c.name, c.total_seats from "
					+ "(select distinct substr(listcode,13,8) sub from playlist "
					+ "where substr(listcode,0,12)='"+moviecode+"' order by sub) "
					+ "join cinema c on sub = c.cinemacode";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Cinema c = new Cinema(rs.getString(1),rs.getString(2),Integer.parseInt(rs.getString(3)));
				cinema_list.add(c);
				//System.out.println(c);
			}

			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cinema_list;
	}
	
	public ArrayList<Playlist> catch_listinfo(String moviecode) {
		ArrayList<Playlist> playlists = new ArrayList<>();
		
		try {
			dbCon();
			String sql = "select * from playlist where "
					+ "substr(listcode,0,12)='"+moviecode+"' order by listcode";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Playlist p = new Playlist(rs.getString(1),rs.getString(2),rs.getString(3),
						Integer.parseInt(rs.getString(4)));
				playlists.add(p);
				//System.out.println(p);
			}

			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return playlists;
	}
	
	public Theater catchtheater(String theatercode) {
		Theater t = null;
		
		try {
			dbCon();
			String sql = "select * from theater where theatercode='"+theatercode+"'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				t = new Theater(rs.getString(1),rs.getString(2),rs.getString(3));
				//System.out.println(t);
			}

			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	
	public Cinema catchcinema(String cinemacode) {
		Cinema c = null;
		
		try {
			dbCon();
			String sql = "select * from cinema where cinemacode='"+cinemacode+"'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				c = new Cinema(rs.getString(1),rs.getString(2),Integer.parseInt(rs.getString(3)));
				//System.out.println(c);
			}

			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public Playlist catchplaylist(String listcode) {
		Playlist p = null;
		
		try {
			dbCon();
			String sql = "select * from playlist where listcode='"+listcode+"'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				p = new Playlist(rs.getString(1),rs.getString(2),rs.getString(3),
						Integer.parseInt(rs.getString(4)));
				//System.out.println(p);
			}

			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}
	
	public ArrayList<Seat> catch_seatinfo(String cinemacode) {
		ArrayList<Seat> seats = new ArrayList<>();
		
		try {
			dbCon();
			String sql = "select * from seat where substr(seatcode,0,8)='"+cinemacode+"' "
					+ "order by seatcode";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Seat s = new Seat(rs.getString(1),rs.getString(2));
				seats.add(s);
				//System.out.println(s);
			}

			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seats;
	}
	
	public void maketicket(String time, String id, int price, String listcode, String seatcode) {
		
		try {
			dbCon();
			String sql = "insert into ticket values( "+time+" || '"
			+((int)(Math.random()*10))+""+(int)(Math.random()*10)+"', "+"'"+id+"', '"+price+
			"', '"+listcode+"', '"+seatcode+"')";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.execute();
			
			System.out.println(sql);
			
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Seat catchseat(String place) {
		Seat s = null;
		try {
			dbCon();
			String sql = "select * from seat where place='"+place+"'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				s = new Seat(rs.getString(1),rs.getString(2));
				//System.out.println(p);
			}

			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	
	public Ticket timecheck_ticket(String time){
		Ticket t = null;
		
		try {
			dbCon();
			String sql = "select * from ticket where substr(ticketcode, 0,14)='"+time+"'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println(sql);
			if(rs.next()) {
				t = new Ticket(rs.getString(1),rs.getString(2), Integer.parseInt(rs.getString(3)),
						rs.getString(4),rs.getString(5));
				System.out.println(t);
			}

			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	
	
	public Customer check_id(String id) {
		Customer c = null;
		
		try {
			dbCon();
			String sql = "select * from customer where id='"+id+"'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				c = new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),Integer.parseInt(rs.getString(8)));
				//System.out.println(c);
			}

			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public Staff check_co(String id) {
		Staff s = null;
		
		try {
			dbCon();
			String sql = "select * from staff where id='"+id+"'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				s = new Staff(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				//System.out.println(c);
			}

			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
	
	
}
