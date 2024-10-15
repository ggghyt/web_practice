package chap05;

import java.util.Arrays;

public class exam_p202 {

	public static void main(String[] args) {
		int[] arr = new int[50];
		int sum = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			arr[i] = (int)(Math.random() * 51) + 50;
			sum = sum + arr[i];
			System.out.printf("%3d ", arr[i]);
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
		
		System.out.println("sum : " + sum);
		System.out.printf("avg : %.3f\n\n", (double)sum / arr.length);
		
		
		
		int[] arr_2 = new int[10];
		int sum_2 = 0;
		int max = 0;
		int min = 100;
		for (int i = 0 ; i < arr_2.length ; i++) {
			int random_num = (int)(Math.random() * 10) + 1;
			if (Arrays.stream(arr_2).anyMatch(num -> random_num == num)) {
				i--;
				continue;
			}
			arr_2[i] = random_num;
			sum_2 = sum_2 + arr_2[i];
			System.out.printf("%3d ", arr_2[i]);
			if (max < arr_2[i]) {
				max = arr_2[i];
			}
			if (min > arr_2[i]) {
				min = arr_2[i];
			}
			
			}
		System.out.println();
		System.out.println("sum : " + sum_2);
		System.out.printf("avg : %.1f\n", (double)sum_2 / arr_2.length);
		System.out.println("max : " + max);
		System.out.println("min : " + min);
		
		System.out.println(Arrays.stream(arr_2).max().getAsInt());
		
		
	}
}
