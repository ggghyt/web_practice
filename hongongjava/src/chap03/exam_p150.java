package chap03;

import java.util.Scanner;

public class exam_p150 {

	public static void main(String[] args) {
		// 4.
		int pencils = 534;
		int students = 30;
		
		int penciles_per_student = pencils / students;
		System.out.println(penciles_per_student);
		
		int penciles_left = pencils % students;
		System.out.println(penciles_left);
		
		// 6.
		int value = 356;
		System.out.println(value / 100 * 100);
		
		// 8.
		int length_top = 5;
		int length_bottom = 10;
		int height = 7;
		double area = ((double) length_top + (double) length_bottom) * (double) height / 2.0;
		System.out.println(area);
		
		// 9.
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1st num : ");
		double first_num = Double.parseDouble(scanner.nextLine());
		System.out.println("2ed num : ");
		double second_num = Double.parseDouble(scanner.nextLine());
		
		if ((int)(second_num) == 0) {
			System.out.println("inf");
		} else {
			double result = first_num / second_num;
			System.out.println(result);
		}
		
		// 10.
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("area : " + var4);
		
		// 11.
		
		System.out.println("id : ");
		String id = scanner.nextLine();
		System.out.println("pw : ");
		int pw = Integer.parseInt(scanner.nextLine());
		
		if (id.equals("java") && pw == 12345) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
		
		scanner.close();
	}

}
