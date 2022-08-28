package DBclass;

public class Cinema {
	private String cinemacode;
	private String name;
	private int total_seats;
	
	public Cinema(String cinemacode, String name, int total_seats) {
		super();
		this.cinemacode = cinemacode;
		this.name = name;
		this.total_seats = total_seats;
	}

	public String getCinemacode() {
		return cinemacode;
	}

	public String getName() {
		return name;
	}

	public int getTotal_seats() {
		return total_seats;
	}

	@Override
	public String toString() {
		return "cinema [cinemacode=" + cinemacode + ", name=" + name + ", total_seats=" + total_seats + "]";
	}
}
