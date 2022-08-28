package project;

public class Customer {
	String id;
	String name;
	String password;
	String phone;
	String dateofbirth;
	String email;
	String gender;
	int point;
	
	

	public Customer() {}
	public Customer(String id, String name, String password, String phone, String dateofbirth ,String email,String gender, int point
			 ) {
		super();
		this.id = id;
		this.name = name;
		this.password = password; 
		this.phone = phone;
		this.email = email;
		this.point = point;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public int getPoint() {
		return point;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public String getGender() {
		return gender;
	}

}
