package Data;

public class Ticket {
	String ticketcode;
	String id;
	String price;
	String seatcode;
	String moviecode;
	public Ticket(String ticketcode, String id, String price, String seatcode, String moviecode) {
		super();
		this.ticketcode = ticketcode;
		this.id = id;
		this.price = price;
		this.seatcode = seatcode;
		this.moviecode = moviecode;
	}
	public String getTicketcode() {
		return ticketcode;
	}
	public String getId() {
		return id;
	}
	public String getPrice() {
		return price;
	}
	public String getSeatcode() {
		return seatcode;
	}
	public String getMoviecode() {
		return moviecode;
	}
	
}
