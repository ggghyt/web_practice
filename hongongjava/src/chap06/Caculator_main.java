package chap06;

public class Caculator_main {

	public static void main(String[] args) {
		Calculator my_cal = new Calculator();
		
		double result1 = my_cal.area_rectangle(10);
		double result2 = my_cal.area_rectangle(10, 20);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
	}

}
