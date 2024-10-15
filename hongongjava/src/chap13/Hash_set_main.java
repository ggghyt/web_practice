package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hash_set_main {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("something");
		set.add("nothing");
		set.add("everything");
		set.add("thingthing");
		set.add("thing");
		
		System.out.println("size : " + set.size());
		
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		set.remove("thingthing");
		set.remove("thing");
		
		System.out.println("size : " + set.size());
		for (String element : set) {
			System.out.println(element);
		}
		
		set.clear();
		System.out.println("size : " + set.size());
		
	}

}
