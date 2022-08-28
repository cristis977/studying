package Data;

public class Theater {
	String theaterrcode;
	String branch_name;
	String address;
	String openingtime;
	String closingtime;
	
	public Theater(String theaterrcode, String branch_name, String address, String openingtime, String closingtime) {
		super();
		this.theaterrcode = theaterrcode;
		this.branch_name = branch_name;
		this.address = address;
		this.openingtime = openingtime;
		this.closingtime = closingtime;
	}
	
	public String getTheaterrcode() {
		return theaterrcode;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public String getAddress() {
		return address;
	}
	public String getOpeningtime() {
		return openingtime;
	}
	public String getClosingtime() {
		return closingtime;
	}
	
}
