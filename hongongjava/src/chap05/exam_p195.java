package chap05;

public class exam_p195 {

	public static void main(String[] args) {
		String str1 = "asdf";
		String str2 = "asdf";
		
		if (str1 == str2) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		if (str1.equals(str2)) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		String str3 = new String("asdf");
		String str4 = new String("asdf");
		
		if (str3 == str4) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		if (str3.equals(str4)) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}

	}

}
