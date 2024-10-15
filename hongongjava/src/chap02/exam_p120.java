package chap02;

import java.util.Scanner;

public class exam_p120 {

	public static void main(String[] args) {
		// 01
		String name = "감자바";
		int age = 25;
		String tel1 = "010", tel2 = "123", tel3 = "4567";
		System.out.println("이름 : " + name);
		System.out.print("나이 : " + age + "\n");
		System.out.printf("전화 : %1$s - %2$s - %3$s\n", tel1, tel2, tel3);
		
		// 02
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("first num : ");
		String str_num1 = scanner.nextLine();
		
		System.out.println("second num : ");
		String str_num2 = scanner.nextLine();
		
		int num1 = Integer.parseInt(str_num1);
		int num2 = Integer.parseInt(str_num2);
		int result = num1 + num2;
		System.out.println("result : " + result);

		// 03
		System.out.println("name : ");
		String name_03 = scanner.nextLine();
		
		System.out.println("personal number : ");
		int number_03 = Integer.parseInt(scanner.nextLine());
		
		System.out.println("tel : ");
		String tel_03 = scanner.nextLine();
		
		System.out.println("name : " + name_03);
		System.out.println("personal number : " + number_03);
		System.out.println("tel : " + tel_03);
		
		// bonus
		System.out.println("first num : ");
		int num_bonus_1 = Integer.parseInt(scanner.nextLine());
		
		System.out.println("second num : ");
		int num_bonus_2 = Integer.parseInt(scanner.nextLine());
		
		System.out.println("result : " + Math.abs(num_bonus_1 - num_bonus_2));
		
		scanner.close();
	}

}
