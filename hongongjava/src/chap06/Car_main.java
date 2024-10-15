package chap06;

public class Car_main {

	public static void main(String[] args) {
		Car my_car = new Car();
		System.out.println("company : " + my_car.company);
		System.out.println("model : " + my_car.model);
		System.out.println("color : " + my_car.color);
		System.out.println("max speed : " + my_car.get_max_speed());
		System.out.println("now speed : " + my_car.get_speed());

		my_car.set_speed(250);
		my_car.color = "white";
		
		System.out.println("edit_color : " + my_car.color);
		System.out.println("edit speed : " + my_car.get_speed());
		
		my_car.set_gas(25);
		my_car.run();
		
		if (my_car.left_gas()) {
			System.out.println("have gas");
		} else {
			System.out.println("need gas");
		}
		
		my_car.input_key();
		my_car.speed_run();
		int speed = my_car.get_speed();
		System.out.println("now speed : " + speed);
	}
}
