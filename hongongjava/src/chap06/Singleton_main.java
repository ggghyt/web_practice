package chap06;

public class Singleton_main {

	public static void main(String[] args) {
		Singleton obj1 = Singleton.get_instance();
		Singleton obj2 = Singleton.get_instance();
		int num;
		
		if (obj1 == obj2) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		obj1.increase();
		obj1.print();
		num = obj1.output();
		System.out.println("num : " + num);
		obj2.increase();
		obj2.print();
		num = obj2.output();
		System.out.println("num : " + num);

	}

}
