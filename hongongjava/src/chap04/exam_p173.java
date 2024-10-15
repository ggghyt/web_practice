package chap04;

public class exam_p173 {

	public static void main(String[] args) {
		int sum = 0;
		int count = 0;
		for (int i = 50 ; i < 101 ; i++) {
			if (i % 3 == 0) {
				sum = sum + i;
				count++;
				System.out.println(i);
			}
		}
		System.out.println(sum);
		System.out.println(count);
		
		int num = 1;
		sum = 0;
		while (true) {
			if (num % 7 == 0) {
				sum = sum + num;
				if (sum > 300) {
					System.out.println("sum : " + sum + ", num : " + num);
					break;
				}
			}			
			num++;
		}
		
		for (int i = 2 ; i < 10 ; i++) {
			for (int j = 1 ; j < 10 ; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
			System.out.println();
		}
		
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
	}
}
