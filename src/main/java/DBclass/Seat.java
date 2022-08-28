package DBclass;

public class Seat {
	private String seatcode;
	private String place;
	
	public Seat(String seatcode, String place) {
		super();
		this.seatcode = seatcode;
		this.place = place;
	}

	public String getSeatcode() {
		return seatcode;
	}

	public String getPlace() {
		return place;
	}

	@Override
	public String toString() {
		return "Seat [seatcode=" + seatcode + ", place=" + place + "]";
	}
}
