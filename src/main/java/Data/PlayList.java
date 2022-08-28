package Data;

public class PlayList {
	String listcode;
	String theatercode;
	String cinemacode;
	String moviecode;
	String start_time;
	String end_time;
	public PlayList(String listcode, String theatercode, String cinemacode, String moviecode, String start_time,
			String end_time) {
		super();
		this.listcode = listcode;
		this.theatercode = theatercode;
		this.cinemacode = cinemacode;
		this.moviecode = moviecode;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	public String getListcode() {
		return listcode;
	}
	public String getTheatercode() {
		return theatercode;
	}
	public String getCinemacode() {
		return cinemacode;
	}
	public String getMoviecode() {
		return moviecode;
	}
	public String getStart_time() {
		return start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
}
