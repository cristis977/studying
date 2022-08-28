package Data;

public class Customer {
	String id;
	String name;
	String password;
	String phone;
	String email;
	int point;
	String preferredTheater;
	String dateofbirth;

	public Customer(String id, String name, String password, String phone, String email, int point,
			String preferredTheater, String dateofbirth) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.point = point;
		this.preferredTheater = preferredTheater;
		this.dateofbirth = dateofbirth;
		
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
	public String getPreferredTheater() {
		return preferredTheater;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}

}
