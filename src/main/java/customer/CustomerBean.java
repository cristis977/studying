package customer;

import java.sql.Timestamp;

public class CustomerBean {
	
	String id;
	String pass1;
	String email;
	String name;
	String phone;
	String gender;
	String birthday; 
	int point;
	//String  reg;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass1() {
		return pass1;
	}
	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
	
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	/*
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public CustomerBean(String id, String pass1, String email, String name, String phone, String gender, String birthday, int point ) {
		super();
		this.id = id;
		this.pass1 = pass1;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.birthday = birthday;
		 this.point = point;
		//this.reg = reg;
	}
	public CustomerBean() {
		
	}

	
	
}
