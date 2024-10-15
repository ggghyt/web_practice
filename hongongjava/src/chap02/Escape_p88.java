package chap02;

public class Escape_p88 {

	public static void main(String[] args) {
		System.out.println("번호\t이름\t직업");
		System.out.print("행 단위 출력\n");
		System.out.print("행 단위 출력\n");
		System.out.println("우리는 \"개발자\" 입니다.");
		System.out.println("봄\\여름\\가을\\겨울");

		// p91
		boolean stop = true;
		if (!stop) {
			System.out.println("중지합니다.");
		} else {
			System.out.println("시작합니다.");
		}
		
		// p103
		byte bytevalue1 = 10;
		byte bytevalue2 = 20;
		int intvalue1 = bytevalue1 + bytevalue2;
		System.out.println(intvalue1);
		
		char charvalue1 = 'A';
		char charvalue2 = 1;
		int intvalue2 = charvalue1 + charvalue2;
		System.out.println(intvalue2);
		
		int intvalue3 = 10;
		int intvalue4 = intvalue3 / 4;
		System.out.println(intvalue4);
		
		int intvalue5 = 10;
		double doublevalue = intvalue5 / 4.0;
		System.out.println(doublevalue);
		
		int x = 1;
		int y = 2;
		double result = (double) x / y;
		System.out.println(result);
		
		// p106
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println("value1 : " + (value1 + 100));
		System.out.println("value2 : " + (value2 + 100));
		System.out.println("value3 : " + value3);
		
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.14);
		String str3 = String.valueOf(true);
		
		System.out.println("str1 : " + (str1 + 100));
		System.out.println("str2 : " + (str2 + 100));
		System.out.println("str3 : " + str3);
		
		// p109 05
		char c1 = 'a';
		char c2 = (char)(c1 + 1);
		System.out.println(c2);
		System.out.println((int)c2);
		
		// 06, 07
		int x_06 = 5;
		int y_06 = 2;
		double result_06 = (double)x_06 / (double)y_06;
		System.out.println(result_06);
		
		// 08
		double var1 = 3.5;
		double var2 = 2.7;
		int result_08 = (int) (var1 + var2);
		System.out.println(result_08);
		
		// 09
		long var1_09 = 2L;
		float var2_09 = 1.8f;
		double var3_09 = 2.5;
		String var4_09 = "3.9";
		int result_09 = (int) ((int) var1_09 + (int) var2_09 + (double) var3_09 + Double.parseDouble(var4_09));
		System.out.println(result_09);
		
		// 10
		String str1_10 = 2 + 3 + "";
		String str2_10 = 2 + "" + 3;
		String str3_10 = "" + 2 + 3;
		System.out.println(str1_10 + "\n" + str2_10 + "\n" + str3_10);
		
		// 11
		byte value_11_1 = Byte.parseByte("10");
		int value_11_2 = Integer.parseInt("1000");
		float value_11_3 = Float.parseFloat("20.5");
		double value_11_4 = Double.parseDouble("3.14159");
		System.out.println(value_11_1 + "\n" + value_11_2 + "\n" + value_11_3 + "\n" + value_11_4);
	}
}
