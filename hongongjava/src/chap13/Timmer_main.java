package chap13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Timmer_main {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long start_time;
		long end_time;
		
		start_time = System.nanoTime();
		for (int i = 0 ; i < 100000 ; i++) {
			list1.add(0, String.valueOf(i));
		}
		end_time = System.nanoTime();
		
		System.out.println("Array : " + (end_time - start_time) + " ns");
		
		
		start_time = System.nanoTime();
		for (int i = 0 ; i < 100000 ; i++) {
			list2.add(0, String.valueOf(i));
		}
		end_time = System.nanoTime();
		
		System.out.println("Linked : " + (end_time - start_time) + " ns");
	}

}
