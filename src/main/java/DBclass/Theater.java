package DBclass;

public class Theater {
	private String theatercode;
	private String brunch_name;
	private String address;
	
	public Theater(String theatercode, String brunch_name, String address) {
		super();
		this.theatercode = theatercode;
		this.brunch_name = brunch_name;
		this.address = address;
	}

	public String getTheatercode() {
		return theatercode;
	}

	public String getBrunch_name() {
		return brunch_name;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "theater [theatercode=" + theatercode + ", brunch_name=" + brunch_name + ", address=" + address + "]";
	}

}
