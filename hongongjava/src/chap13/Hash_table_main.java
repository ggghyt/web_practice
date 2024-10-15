package chap13;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Hash_table_main {

	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<String, String>();
		map.put("asdf", "1234");
		map.put("qwer", "1234");
		map.put("zxcv", "9876");
		map.put("1234", "5678");
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("id : ");
			String id = scanner.nextLine();
			System.out.print("pw : ");
			String pw = scanner.nextLine();
			
			if (map.containsKey(id)) {
				if (map.get(id).equals(pw)) {
					System.out.println("success");
					break;
				} else {
					System.out.println("no match");
				}
			} else {
				System.out.println("no id");
			}
		}
		scanner.close();
	}

}
