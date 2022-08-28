package Data;

public class Cinema {
	String cinemacode;
	String theatercode;
	String name;
	String total_seats;
	public Cinema(String cinemacode, String theatercode, String name, String total_seats) {
		super();
		this.cinemacode = cinemacode;
		this.theatercode = theatercode;
		this.name = name;
		this.total_seats = total_seats;
	}
	public String getCinemacode() {
		return cinemacode;
	}
	public String getTheatercode() {
		return theatercode;
	}
	public String getName() {
		return name;
	}
	public String getTotal_seats() {
		return total_seats;
	}
}
