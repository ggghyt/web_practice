package 최민규;

import java.util.Scanner;

public class do_self {

	public static void main(String[] args) {
		// 1.
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("년도 입력 : ");
		int input = Integer.parseInt(scanner.nextLine());
		if (input % 400 == 0) {
			System.out.println(input + "년은 윤년");
		} else if (input % 100 == 0) {
			System.out.println(input + "년은 윤년 아님");
		} else if (input % 4 == 0) {
			System.out.println(input + "년은 윤년");
		} else {
			System.out.println(input + "년은 윤년 아님");
		}

		// 2.
		System.out.println("금액 입력 : ");
		input = Integer.parseInt(scanner.nextLine());
		int left = input;
		System.out.println("500원 : " + left / 500);
		left = left % 500;
		System.out.println("100원 : " + left / 100);
		left = left % 100;
		System.out.println("50원 : " + left / 50);
		left = left % 50;
		System.out.println("10원 : " + left / 10);
		left = left % 10;
		System.out.println("교환 금액 : " + (input - left));
		System.out.println("남은 금액 : " + left);
		
		// 3.
		int num = (int) (Math.random() * 100) + 1;
		while (true) {
			System.out.println("input num : ");
			input = Integer.parseInt(scanner.nextLine());
			if (input > num) {
				System.out.println("down");
			} else if (input < num) {
				System.out.println("up");
			} else {
				System.out.println("match");
				break;
			}
		}
		
		// 4.
		for (int i = 0 ; i < 10 ; i++) {
			System.out.print("| ");
			for (int j = 2 ; j < 10 ; j++) {
				if (i == 0) {
					System.out.printf("    %d      | ", j);
				} else {
					System.out.printf("%d * %d = %2d | ", j, i, (i * j));
				}
			}
			System.out.println();
		}
		
		// 5.
		while (true) {
			System.out.println("----------------------------------------");
			System.out.println("1 : 화씨 -> 섭씨 | 2 : 섭씨 -> 화씨 | 3 : 종료");
			System.out.println("----------------------------------------");
			
			System.out.print("번호 선택 : ");
			input = Integer.parseInt(scanner.nextLine());
			
			if (input == 1) {
				System.out.print("화씨 입력 : ");
				input = Integer.parseInt(scanner.nextLine());
				System.out.println("섭씨 온도 : " + ((double) input - 32) * 5 / 9);
			} else if (input == 2) {
				System.out.print("섭씨 입력 : ");
				input = Integer.parseInt(scanner.nextLine());
				System.out.println("화씨 온도 : " + ((double) input * 9 / 5 + 32));
			} else if (input == 3) {
				System.out.println("종료합니다.");
				break;
			}
			
		}
		
		// 6.
		while (true) {
			System.out.print("가위(0), 바위(1), 보(2) : ");
			input = Integer.parseInt(scanner.nextLine());
			num = (int) (Math.random() * 3);
			if (input > 2) {
				System.out.println("종료");
				break;
			} else if (input == num) {
				System.out.println("사람 : " + input + "컴퓨터 : " + num + " 비겼음");
			} else if ((input + 1) % 3 == num) {
				System.out.println("사람 : " + input + "컴퓨터 : " + num + " 졌음");
			} else if ((input + 2) % 3 == num) {
				System.out.println("사람 : " + input + "컴퓨터 : " + num + " 이겼음");
			}
		}
		
		// 7.
		for (int i = 1 ; i < 51 ; i++) {
			int check = 0;
			if (((i % 10) != 0) && (i % 10) % 3 == 0) {
				System.out.print("★");
				check = 1;
			}
			if (((i / 10) != 0) && (i / 10) % 3 == 0) {
				System.out.print("★");
				check = 1;
			}
			if (check == 0) {
				System.out.print(i);
			}
			System.out.print("\t");
			if (i % 10 == 0) {
				System.out.println();
			}
		}
		
		scanner.close();
	}

}
