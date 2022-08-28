package DBclass;

public class Staff {
	private String id;
	private String name;
	private String password;
	private String phone;
	private String birthday;
	private String email;
	private String gender;
	private String division;
	private String position;
	
	public Staff(String id, String name, String password, String phone, String birthday, String email, 
			String gender, String division, String position) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.birthday = birthday;
		this.email = email;
		this.gender = gender;
		this.division = division;
		this.position = position;
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

	public String getDivision() {
		return division;
	}

	public String getPosition() {
		return position;
	}
}
