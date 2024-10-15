package chap13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Hash_map_main {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("someone", 256);
		map.put("sometwo", 12);
		map.put("somethree", 49);
		map.put("somefour", 1024);
		map.put("someone", 1357);
		System.out.println("size : " + map.size());
		
		System.out.println("someone : " + map.get("someone"));
		
		
		Set<String> key_set = map.keySet();
		Iterator<String> key_iterator = key_set.iterator();
		while(key_iterator.hasNext()) {
			String key = key_iterator.next();
			Integer value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
		map.remove("somethree");
		System.out.println("size : " + map.size());
		
		Set<Map.Entry<String, Integer>> entry_set = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entry_iterator = entry_set.iterator();
		
		while (entry_iterator.hasNext()) {
			Map.Entry<String, Integer> entry = entry_iterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		map.clear();
		System.out.println("size : " + map.size());
	}

}
