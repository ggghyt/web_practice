package chap06;

public class Board_main {

	public static void main(String[] args) {
		Board board1 = new Board("main", "input");
		Board board2 = new Board("something", "nothing", "someone");
		Board board3 = new Board("first", "1st", "everyone", "not now");
		Board board4 = new Board("not title", "not content", "not writer", "not date", 1024);

		System.out.println(board1.title + " / " + board1.content + " / " + board1.writer + " / " + board1.date + " / " + board1.hitcount);
		System.out.println(board2.title + " / " + board2.content + " / " + board2.writer + " / " + board2.date + " / " + board2.hitcount);
		System.out.println(board3.title + " / " + board3.content + " / " + board3.writer + " / " + board3.date + " / " + board3.hitcount);
		System.out.println(board4.title + " / " + board4.content + " / " + board4.writer + " / " + board4.date + " / " + board4.hitcount);
	}

}
