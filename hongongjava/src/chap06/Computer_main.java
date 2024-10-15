package chap06;

public class Computer_main {

	public static void main(String[] args) {
		Computer computer = new Computer();
		
		int[] value1 = {1, 2, 3};
		System.out.println("result : " + computer.sum1(value1));
		
		System.out.println("result : " + computer.sum1(new int[] {1, 2, 3, 4, 5}));
		
		System.out.println("result : " + computer.sum2(1, 2, 3));
		
		System.out.println("result : " + computer.sum2(1, 2, 3, 4, 5));
	}

}
