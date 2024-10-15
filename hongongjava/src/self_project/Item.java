package self_project;

public class Item {
	private int item_num;
	private String item_name;
	private String item_content;
	private int item_left;
	private int item_price;
	
	public int get_item_num() {
		return item_num;
	}
	public void set_item_num(int item_num) {
		this.item_num = item_num;
	}
	public String get_item_name() {
		return item_name;
	}
	public void set_item_name(String item_name) {
		this.item_name = item_name;
	}
	public String get_item_content() {
		return item_content;
	}
	public void set_item_content(String item_content) {
		this.item_content = item_content;
	}
	public int get_item_left() {
		return item_left;
	}
	public void set_item_left(int item_left) {
		this.item_left = item_left;
	}
	public int get_item_price() {
		return item_price;
	}
	public void set_item_price(int item_price) {
		this.item_price = item_price;
	}
}
