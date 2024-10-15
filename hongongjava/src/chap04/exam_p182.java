package chap04;

import java.util.Scanner;

public class exam_p182 {

	public static void main(String[] args) {
		// 4.
		for (int i = 1; i < 11; i++) {
			if (((60 - (i * 4)) % 5) == 0) {
				System.out.print("( " + i + ", " + ((60 - (i * 4)) / 5) + " ) ");
			}
		}
		System.out.println();

		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				if ((i * 4 + j * 5) == 60) {
					System.out.print("( " + i + ", " + j + " ) ");
				}
			}
		}
		System.out.println();

		// 5.
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		int star = 1;
		int sum = 1;
		for (int i = 1 ; star < 8 ; i++) {
			System.out.print("*");
			if (i == sum) {
				System.out.println();
				star++;
				sum = sum + star;
			}
		}

		// 6.
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 7.
		boolean run = true;
		int balance = 0;
		int select = 0;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1 : 예금 | 2 : 출금 | 3 : 잔고 | 4 : 종료");
			System.out.println("-------------------------------------");

			System.out.print("선택 : ");
			try {
				select = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요");
				continue;
			}

			if (select == 1) {
				System.out.print("예금액 : ");
				int input = Integer.parseInt(scanner.nextLine());
				balance = balance + input;
			} else if (select == 2) {
				System.out.print("출금액 : ");
				int input = Integer.parseInt(scanner.nextLine());
				if (balance < input) {
					System.out.println("you have only " + balance);
					break;
				}
				balance = balance - input;
			} else if (select == 3) {
				System.out.println("잔고 : " + balance);
			} else if (select == 4) {
				break;
			} else {
				System.out.println("잘못된 숫자 입력");
			}
		}
		System.out.println("프로그램 종료");

		scanner.close();
	}
}
