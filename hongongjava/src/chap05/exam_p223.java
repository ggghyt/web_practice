package chap05;

import java.util.Scanner;

public class exam_p223 {

	public static void main(String[] args) {
		boolean run = true;
		int student = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1. 학생 수 | 2. 점수 입력 | 3. 점수 리스트 | 4. 분석 | 5. 종료");
			System.out.println("-----------------------------------------------------");
			System.out.print("선택 : ");
			int select = Integer.parseInt(scanner.nextLine());
			switch(select) {
			case 1:
				System.out.print("학생 수 : ");
				student = Integer.parseInt(scanner.nextLine());
				scores = new int[student];
				break;
			case 2:
				for (int i = 0 ; i < student ; i++) {
					System.out.print("scores[" + i + "] : ");
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
				break;
			case 3:
				for (int i = 0 ; i < student ; i++) {
					System.out.println("scores[" + i + "] : " + scores[i]);
				}
				break;
			case 4:
				int sum = 0;
				int max = 0;
				for (int i = 0 ; i < student ; i++) {
					sum = sum + scores[i];
					if (max < scores[i])
						max = scores[i];
				}
				System.out.println("최고 점수 : " + max);
				System.out.println("평균 점수 : " + (double)sum / student);
				break;
			case 5:
				run = false;
				
				scanner.close();
			}
		}
	}
}
