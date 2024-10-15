package chap04;

public class exam_p162 {

	public static void main(String[] args) {
		int count = 0;
		while (true) {
			int num1 = (int) (Math.random() * 6) + 1;
			int num2 = (int) (Math.random() * 6) + 1;
			count++;
			if ((num1 + num2) == 5) {
				System.out.println("result : " + num1 + ", " + num2 + "\n" + count + " break");
				break;
			} else {
				System.out.println("result : " + num1 + ", " + num2 + " ");
			}
		}
		int num3 = (int) ((Math.random()) * 6) + 1;
		System.out.println(num3 + "!");
		
		
		int num = (int) ((Math.random() * 51) + 50);
		
		switch (num / 10) {
		case 10:
			System.out.println("1/51 !");
		case 9 :
			System.out.println("A");
			break;
		case 8 :
			System.out.println("B");
			break;
		case 7 :
			System.out.println("C");
			break;
		case 6 :
			System.out.println("D");
			break;
		case 5 :
			System.out.println("F");
			break;
		}
		System.out.println("num : " + num);
		
		
	}

}
