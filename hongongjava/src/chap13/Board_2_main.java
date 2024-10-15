package chap13;

import java.util.List;

public class Board_2_main {

	public static void main(String[] args) {
		Board_2_dao dao = new Board_2_dao();
		List<Board_2> list = dao.get_board_list();
		for (Board_2 index : list) {
			System.out.println(index.get_title() + " - " + index.get_content());
		}

	}

}
