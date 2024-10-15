package chap06;

public class Car {
	String company = "hyondae";
	String model = "granger";
	String color = "black";
	private int max_speed = 530;
	private int speed;
	private int gas;
	private boolean gas_state;
	
	
	public boolean is_gas_state() {
		return gas_state;
	}

	public void set_gas_state(boolean gas_state) {
		this.gas_state = gas_state;
	}

	int get_speed() {
		return speed;
	}

	public void set_speed(int speed) {
		this.speed = speed;
	}

	public int get_gas() {
		return gas;
	}

	public void set_gas(int gas) {
		this.gas = gas;
	}

	boolean left_gas() {
		if (gas == 0) {
			System.out.println("no gas");
			return false;
		} else {
			System.out.println("yes gas");
			return true;
		}
	}
	
	public int get_max_speed() {
		return max_speed;
	}

	public void set_max_speed(int max_speed) {
		this.max_speed = max_speed;
	}

	void run () {
		while (gas > 0) {
			System.out.println("use gas / left : " + gas + "gas");
			gas--;			
		}
		System.out.println("stop");
	}
	
	
	void input_key() {
		System.out.println("turn on");
	}
	
	void speed_run() {
		int i = 0;
		while (i < 100) {
			int random = (int)(Math.random() * 10 + 5);
			i = i + random;
			System.out.println("run speed : " + i);
		}
		speed = i;
	}
}
