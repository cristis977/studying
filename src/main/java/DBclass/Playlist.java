package DBclass;

public class Playlist {
	private String listcode;
	private String start_time;
	private String end_time;
	private int price;
	
	public Playlist(String listcode, String start_time, String end_time, int price) {
		super();
		this.listcode = listcode;
		this.start_time = start_time;
		this.end_time = end_time;
		this.price = price;
	}

	public String getListcode() {
		return listcode;
	}

	public String getStart_time() {
		return start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Playlist [listcode=" + listcode + ", start_time=" + start_time + ", end_time=" + end_time + ", price="
				+ price + "]";
	}
	
}
