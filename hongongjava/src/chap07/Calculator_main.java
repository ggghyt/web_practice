package chap07;

public class Calculator_main {

	public static void main(String[] args) {
		Computer com = new Computer();
		Calculator cal = new Calculator();
		
		double result = com.area_circle(10);
		System.out.println(result);
		
		result = cal.area_circle(10);
		System.out.println(result);
		
		result = com.area_circle(10);
		System.out.println(result);

	}

}
