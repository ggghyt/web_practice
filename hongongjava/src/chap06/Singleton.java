package chap06;

public class Singleton {
	private static Singleton singleton = new Singleton();
	static int num = 0;
	
	private Singleton() {}
	
	static Singleton get_instance() {
		return singleton;
	}
	
	int increase() {
		num++;
		return num;
	}
	
	void print() {
		System.out.println(num);
	}
	
	int output() {
		return num;
	}
}
