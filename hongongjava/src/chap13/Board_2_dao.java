package chap13;

import java.util.ArrayList;
import java.util.List;

public class Board_2_dao {
	
	public List<Board_2> get_board_list() {
		List<Board_2> list = new ArrayList<Board_2>();
		list.add(new Board_2("title1", "content1"));
		list.add(new Board_2("title2", "content2"));
		list.add(new Board_2("title3", "content3"));
			
		return list;
	}
}
