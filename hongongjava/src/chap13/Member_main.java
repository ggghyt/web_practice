package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Member_main {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("something", 1));
		set.add(new Member("something", 1));
		set.add(new Member("something", 2));
		set.add(new Member("something", 3));
		
		System.out.println("size : " + set.size());
		
		Iterator<Member> iterator = set.iterator();
		while (iterator.hasNext()){
			Member index = iterator.next();
			System.out.println(index.name + " " + index.age);
		}
	}

}
