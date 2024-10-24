package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardList(int page);
	List<BoardVO> listWithPage(SearchDTO search);
	int insertBoard(BoardVO board);
	int updateBoard(BoardVO board);
	int deleteBoard(int board_num);
	BoardVO selectBoard(int board_num);
	int updateCount(int board_num);
	int selectCount(SearchDTO search);
	List<Map<String, Object>> countByWriter();
}
