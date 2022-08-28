package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchDao {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";
	
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	public void updatePw(String id, String npw) {
		
		
		try {
			dbCon();
			String sql = "update Normalcust set pw=? where id=?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, npw);
			pst.setString(2, id);
			
			pst.executeUpdate();
			
			pst.close();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Customer> show_userinfo() { 
			
			ArrayList<Customer> list = new ArrayList<>();
			
			
			try {
				dbCon();
				st = con.createStatement();
				String sql = "select * from Normalcust";
				rs = st.executeQuery(sql);
				
				while(rs.next()) {
					Customer m = new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
					list.add(m);
				}
				
				
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		
	}
	
	
	
	public Customer getuserinfo(String id) {
		Customer n = null;
		try {
			dbCon();
			String sql = "select * from Normalcust where id=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				n= new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	
	}
		
		
	
	
	
	
	
	
	
	public void User_Register(Customer user){
		
		
		try {
			dbCon();
			String sql = "insert into Normalcust values(?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getId());
			pst.setString(2, user.getName());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getPhone());
			pst.setString(5, user.getEmail());
			pst.setInt(6, user.getPoint());
			pst.setString(7, user.getPreferredTheater());
			pst.setString(8, user.getDateofbirth());
			
			
			pst.executeUpdate();
			
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean duplicatedID(String id) {
		boolean result=false;
		
	
		try {
			dbCon();
			String  sql ="select decode( count(* ), 1 ,'true','false') ";
			        sql += " from Normalcust where m_id=?";
			        //테이블 수정 필요
			PreparedStatement pst  = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs  =pst.executeQuery();
			
			if( rs.next()) { 
				result = Boolean.parseBoolean(rs.getString(1));
			}
			
			rs.close();
			pst.close();
			con.close();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	private void dbCon() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
