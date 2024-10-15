package chap05;

import java.util.Arrays;

public class exam_p214 {

	public static void main(String[] args) {
		int [][] arr = new int[10][10];
		
		for (int i = 0 ; i < arr.length * arr[0].length; i++) {
			int num = (int) (Math.random() * 100) + 1;
			int[] arr_one = Arrays.stream(arr)
			        .flatMapToInt(Arrays::stream)
			        .toArray();
			if (Arrays.stream(arr_one).anyMatch(index -> index == num)) {
				i--;
				continue;
			}
			
			arr[i / arr[0].length][i % arr[0].length] = num;
			System.out.printf("%4d", arr[i / arr[0].length][i % arr[0].length]);
			
			if ((i + 1) % arr[0].length == 0) {
				System.out.println();
			}
		}
		
		int[] nums = {10, 200, 30, 40, -50, 777, 555};
		int sum = 0;
		int max = 0;
		int min = 0;
		for (int i : nums) {
			sum = sum + i;
			if (max < i) {
				max = i;
			}
			if (min > i) {
				min = i;
			}
		}
		System.out.println("sum : " + sum);
		System.out.println("sum : " + max);
		System.out.println("sum : " + min);
		

	}

}
