package chap06;

public class Shopservice_main {

	public static void main(String[] args) {
		Shopservice obj1 = Shopservice.get_instance();
		Shopservice obj2 = Shopservice.get_instance();
		
		if (obj1 == obj2) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
	}

}
