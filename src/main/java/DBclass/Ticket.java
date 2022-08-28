package DBclass;

public class Ticket {
	private String ticketcode;
	private String id;
	private int price;
	private String listcode;
	private String seatcode;
	
	public Ticket(String ticketcode, String id, int price, String listcode, String seatcode) {
		super();
		this.ticketcode = ticketcode;
		this.id = id;
		this.price = price;
		this.listcode = listcode;
		this.seatcode = seatcode;
	}

	public String getTicketcode() {
		return ticketcode;
	}

	public String getId() {
		return id;
	}

	public int getPrice() {
		return price;
	}

	public String getListcode() {
		return listcode;
	}

	public String getSeatcode() {
		return seatcode;
	}

	@Override
	public String toString() {
		return "Ticket [ticketcode=" + ticketcode + ", id=" + id + ", price=" + price + ", listcode=" + listcode
				+ ", seatcode=" + seatcode + "]";
	}
	
}
