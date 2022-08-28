package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CustomerDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";
	Connection con = null;
	
	PreparedStatement pst; 
	ResultSet rs;
	
	
	public int duplicatedID( String id){
		int result=0;
		dbCon();
		String sql =" select id from CUSTOMER where id  =?";
		try {
			PreparedStatement pst  =con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs  =pst.executeQuery();
			
			if( rs.next()) {
				result=1;   //  �븘�씠�뵒 議댁옱
			}
			
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
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void MemberInsert(CustomerBean bean) {
		
		try {  
			
			dbCon();
			String sql = "insert into CUSTOMER values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, bean.getId());
			pst.setString(2, bean.getName());
			pst.setString(3, bean.getPass1());
			pst.setString(4, bean.getPhone());
			pst.setString(5, bean.getBirthday());
			pst.setString(6, bean.getEmail());
			pst.setString(7, bean.getGender());
			pst.setInt(8 , bean.getPoint());
			
			
			
			//pst.setInt(8, bean.getPoint());
			
			pst.executeUpdate();
			
			pst.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//MemberInsert end

	public ArrayList<CustomerBean> getAllList(){
		ArrayList<CustomerBean> list = new ArrayList<>();
	
		try { 
			dbCon();
			Statement st = con.createStatement();
			String sql = "select * from CUSTOMER";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				CustomerBean bean = new CustomerBean(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7) ,0);
				list.add(bean);
			}
			pst.close();
			rs.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAO();
		int result  =dao.duplicatedID("ggggf");
		System.out.println(  result);
	}
}