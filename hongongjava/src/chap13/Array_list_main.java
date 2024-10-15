package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Array_list_main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		
		list.add("first");
		list.add("second");
		list.add("third");
		for (int i = 0 ; i < 2 ; i++) {
			System.out.print("input : ");
			list.add(scanner.nextLine());
		}
		System.out.println();
		for (int i = 0 ; i < list.size() ; i++) {
			System.out.println(i + "'s list : " + list.get(i));
		}
		System.out.println();
		for (int i = 0 ; i < (int)(Math.random() * 5 + 1) ; i++) {
			list.remove((int)(Math.random() * 4 + 1 - i));
		}
		System.out.println();
		for (int i = 0 ; i < list.size() ; i++) {
			System.out.println(i + "'s list : " + list.get(i));
		}
		
		scanner.close();
	}

}
