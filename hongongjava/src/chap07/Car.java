package chap07;

public class Car {
	Tire fltire = new Tire("front left", (int)(Math.random() * 5 + 2));
	Tire frtire = new Tire("front right", (int)(Math.random() * 5 + 2));
	Tire bltire = new Tire("back left", (int)(Math.random() * 5 + 2));
	Tire brtire = new Tire("back right", (int)(Math.random() * 5 + 2));
	
	int run() {
		int count = 0;
		System.out.println("run~");
		if (fltire.roll() == false) {
			stop();
			count = count + 1;
		}
		if (frtire.roll() == false) {
			stop();
			count = count + 10;
		}
		if (bltire.roll() == false) {
			stop();
			count = count + 100;
		}
		if (brtire.roll() == false) {
			stop();
			count = count + 1000;
		}
		return count;
	}
	
	void stop() {
		System.out.println("tire is dead");
	}
}
