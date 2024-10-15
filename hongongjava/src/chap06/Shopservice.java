package chap06;

public class Shopservice {
	private static Shopservice singleton = new Shopservice();
	
	private Shopservice() {}
	
	static Shopservice get_instance() {
		return singleton;
	}
}
