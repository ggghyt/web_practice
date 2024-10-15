package chap13;

import java.util.List;
import java.util.Vector;

public class Board_main {

	public static void main(String[] args) {
		List<Board> list = new Vector<Board>();
		
		list.add(new Board("1st", "one", "first"));
		list.add(new Board("2ed", "two", "second"));
		list.add(new Board("3rd", "three", "third"));
		list.add(new Board("4th", "four", "fourth"));
		list.add(new Board("5th", "five", "fifth"));
		
		list.remove((int)(Math.random() * 5));
		list.remove((int)(Math.random() * 4));
		
		for (int i = 0 ; i < list.size() ; i++) {
			Board board = list.get(i);
			System.out.println(board.subject + " " + board.content + " " + board.writer);
		}
		
		Board bd = new Board("nothing", "something", "everything");
		System.out.println(bd);
		System.out.println(bd.hashCode());
		System.out.println(bd.toString());
	}

}
