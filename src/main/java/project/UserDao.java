package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDao {
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";
	
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	boolean flag = false;

	
	public void Updateuserinfo(String id, String name, String pw, String phone, String birth, String email, int point  ) { // 사용 안함
		
		
		try {
			dbCon();
			String sql = "update customer set name=?, password=?, phone=?, birthday=?, email=?, point=? where id=?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, name);
			pst.setString(2, pw);
			pst.setString(3, phone);
			pst.setString(4, birth);
			pst.setString(5, email);
			pst.setInt(6, point);
			pst.setString(7, id);
			
			pst.close();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void getuserInfo(String id) {
		ArrayList<Customer> list = new ArrayList<>();
		
		try {
			dbCon();
			String sql = "select id from customer where id=?";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				Customer c = new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				list.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public boolean login_user(String id, String pw) { // 일단 사용 안함
		
		try {
			dbCon();
			String sql = "select id from customer where id = ? and password=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery();
			flag = rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	

	public int User_login(String id, String pw) { // 현재 사용중
		
		try {
			dbCon();
			String sql = "select password from customer where id= ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if(rs.next()) { 
				if(rs.getString(1).contentEquals(pw)) {
					System.out.println("로그인 성공");
					
					return 1; // 로그인 성공값
				}
				else {
					System.out.println("로그인 실패");
					return 0; //로그인 실패값
					
				}
			}
			System.out.println("로그인 실패");
			return -1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -2;
	}
	
	private void dbCon() {
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			if( con != null) { System.out.println("db ok");}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}
	

	/*public static void main(String args[]) {
		String id="m100";
		String pw="1234";
		UserDao dao = new UserDao();
		int result = dao.User_login(id, pw);
		System.out.println(result);
		System.out.println(pw);
		
		
	}*/			

	
}