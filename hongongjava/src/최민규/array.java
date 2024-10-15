package 최민규;

public class array {

	public static void main(String[] args) {
		// 01.
		int[] arr_01 = new int[5];
		int sum = 0;
		int max = 0;
		int min = 100;
		for (int i = 0 ; i < 5 ; i ++) {
			arr_01[i] = (int)(Math.random() * 100) + 1;
			System.out.print(arr_01[i] + " ");
			sum = sum + arr_01[i];
			if (max < arr_01[i]) {
				max = arr_01[i];
			}
			if (min > arr_01[i]) {
				min = arr_01[i];
			}
		}
		System.out.println();
		System.out.println("sum : " + sum);
		System.out.println("max : " + max);
		System.out.println("min : " + min);
		
		System.out.println();
		// 02.
		int[][] arr_02 = {
				{1, 2, 3}, 
				{1, 2}, 
				{1}, 
				{1, 2, 3}
		};
		
		for (int i = 0 ; i < arr_02.length ; i++) {
			for (int j = 0 ; j < arr_02[i].length ; j++) {
				System.out.print(arr_02[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		// 03.
		int[][] arr_03 = new int[3][10];
		int count = 0;
		
		for (int i = 0 ; i < arr_03.length ; i++) {
			for (int j = 0 ; j < arr_03[i].length ; j++) {
				arr_03[i][j] = (int)(Math.random() * 2);
				if (arr_03[i][j] == 1) {
					count++;
				}
				System.out.print(arr_03[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("sum : " + count);
		
		System.out.println();
		// 04.
		int[][] arr_04 = new int[3][5];
		
		for (int i = 0 ; i < arr_04.length ; i++) {
			for (int j = 0 ; j < arr_04[i].length ; j++) {
				arr_04[i][j] = (int)(Math.random() * 51) + 50;
				System.out.printf(arr_04[i][j] + "\t");
			}
			System.out.println();
		}
		int avg = 0;
		for (int i = 0 ; i < arr_04.length * arr_04[0].length ; i++) {
			avg = avg + arr_04[i / arr_04[0].length][i % arr_04[0].length];
			if ((i + 1) % arr_04[0].length == 0) {
				System.out.println((i / arr_04[0].length + 1) + "'s avg : " + (avg / arr_04[0].length));
				avg = 0;
			}
		}
		
		System.out.println();
		// 05.
		String[][] arr_05 = {
				{"Clubs", "Diamonds", "Hearts", "Spades"}, 
				{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}
		};
		
		for (int i = 0 ; i < 5 ; i++) {
			System.out.println(arr_05[0][(int)(Math.random() * 4)] + "'s " + arr_05[1][(int)(Math.random() * 13)]);
		}
		
		System.out.println();
		// 06.
		int[][] arr_06 = new int[3][5];
		for (int i = 0 ; i < 5 ; i++) {
			int ran_num = (int)(Math.random() * 15);
			if (arr_06[ran_num / arr_06[0].length][ran_num % arr_06[0].length] == 1) {
				i--;
				continue;
			} else {
				arr_06[ran_num / arr_06[0].length][ran_num % arr_06[0].length] = 1;
			}
		}
		
		for (int i = 0 ; i < arr_06.length * arr_06[0].length; i++) {
			System.out.printf("%3d", arr_06[i / arr_06[0].length][i % arr_06[0].length]);
			if ((i + 1) % arr_06[0].length == 0) {
				System.out.println();
			}
		}
	}

}
