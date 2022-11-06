import java.util.Vector;

public class Album {
	private String id;
	private String title;
	private int year;
	private int track;
	private int rating;
	private double price;
	private Vector<Tracks> SubVec; 
	
	
	
	
	public Album(String id, String title, int year, int track, int rating, double price, Vector<Tracks> subVec) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.track = track;
		this.rating = rating;
		this.price = price;
		SubVec = subVec;
		
	}
	public Vector<Tracks> getSubVec() {
		return SubVec;
	}
	public void setSubVec(Vector<Tracks> subVec) {
		SubVec = subVec;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
