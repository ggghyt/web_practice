package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardList(SearchDTO search); 
	boolean registerBoard(BoardVO board);
	boolean removeBoard(int board_num);
	boolean modifyBoard(BoardVO board);
	BoardVO searchBoard(int board_num);
	int getTotalCount(SearchDTO search);
}
