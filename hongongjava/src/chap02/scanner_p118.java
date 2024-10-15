package chap02;

import java.util.Scanner;

public class scanner_p118 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		int input_num = 0;
		
		while (true) {
			input = scanner.nextLine();
			System.out.println("input : " + input);
			input_num = Integer.parseInt(scanner.nextLine());
			System.out.println("input : " + input_num);
			if (input.equals("exit") || input_num == 0) {
				System.out.println("Quit.");
				scanner.close();
				break;
			}
		}
	}
}