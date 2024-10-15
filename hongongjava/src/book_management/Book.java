package book_management;

public class Book {
	private String title;
	private String writer;
	private int price;
	private String bnum;
	
	
	public String get_title() {
		return title;
	}
	public void set_title(String title) {
		this.title = title;
	}
	public String get_writer() {
		return writer;
	}
	public void set_writer(String writer) {
		this.writer = writer;
	}
	public int get_price() {
		return price;
	}
	public void set_price(int price) {
		this.price = price;
	}
	public String get_bnum() {
		return bnum;
	}
	public void set_bnum(String bnum) {
		this.bnum = bnum;
	}
	
	@Override
	public String toString() {
		return title + ", " + writer + ", " + price + ", " + bnum;
	}
}
