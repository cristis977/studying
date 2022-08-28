package DBclass;

public class Customer {
	private String id;
	private String name;
	private String password;
	private String phone;
	private String birthday;
	private String email;
	private String gender;
	private int point;
	
	public Customer(String id, String name, String password, String phone, String birthday, 
			String email, String gender, int point) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.birthday = birthday;
		this.email = email;
		this.gender = gender;
		this.point = point;
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

	public String getBirthday() {
		return birthday;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public int getPoint() {
		return point;
	}
}
