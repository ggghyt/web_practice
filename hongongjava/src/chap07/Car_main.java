package chap07;

public class Car_main {

	public static void main(String[] args) {
		Car car = new Car();
		for (int i = 0 ; i < 100 ; i++) {
			int problem = car.run();
			
			if (problem % 10 >= 1) {
				System.out.println("front left tire is dead");
				car.fltire = new HK_tire("front left", (int)(Math.random() * 10 + 5));
			}
			if (problem % 100 >= 10) {
				System.out.println("front right tire is dead");
				car.frtire = new HK_tire("front right", (int)(Math.random() * 10 + 5));
			}
			if (problem % 1000 >= 100) {
				System.out.println("back left tire is dead");
				car.bltire = new KH_tire("back left", (int)(Math.random() * 10 + 5));
			}
			if (problem >= 1000) {
				System.out.println("back right tire is dead");
				car.brtire = new KH_tire("back right", (int)(Math.random() * 10 + 5));
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("-------------------------");
		}
	}

}
