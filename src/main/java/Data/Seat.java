package Data;

public class Seat {
	String seatcode;
	String cinemacode;
	String row;
	String column;
	public Seat(String seatcode, String cinemacode, String row, String column) {
		super();
		this.seatcode = seatcode;
		this.cinemacode = cinemacode;
		this.row = row;
		this.column = column;
	}
	public String getSeatcode() {
		return seatcode;
	}
	public String getCinemacode() {
		return cinemacode;
	}
	public String getRow() {
		return row;
	}
	public String getColumn() {
		return column;
	}
	
}
